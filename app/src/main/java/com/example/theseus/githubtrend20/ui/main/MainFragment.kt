package com.example.theseus.githubtrend20.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theseus.githubtrend20.GithubRepoApplication
import com.example.theseus.githubtrend20.R
import com.example.theseus.githubtrend20.di.modules.MainFragmentModule
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
    @Inject
    lateinit var mMainViewModelFactory: MainViewModelFactory
    @Inject
    lateinit var mGithubListAdapter: GithubRepoListAdapter
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireContext().applicationContext as GithubRepoApplication)
            .mApplicationComponent.mainFragmentComponent(MainFragmentModule())
            .inject(this)
        viewModel = ViewModelProviders.of(this,mMainViewModelFactory).get(MainViewModel::class.java)
        github_repo_list.adapter = mGithubListAdapter
        setupViews()
    }

    private fun setupViews() {
        viewModel.githubRepo.observe(viewLifecycleOwner, Observer {
            it?.let {
                mGithubListAdapter.githubRepoList = it
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    loading.visibility = View.VISIBLE
                    error_views.visibility = View.GONE
                }else{
                    loading.visibility = View.GONE
                    error_views.visibility = View.VISIBLE
                }
                retry.isEnabled = !it
            }
        })
        viewModel.isDataFetchSuccessful.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    error_views.visibility = View.GONE
                }else{
                    error_views.visibility = View.VISIBLE
                }
            }
        })
        retry.setOnClickListener {
            viewModel.fetchGithubRepo()
        }
    }

}
