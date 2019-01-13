package com.example.theseus.githubtrend20.ui.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.theseus.githubtrend20.MainActivity
import com.example.theseus.githubtrend20.R
import com.example.theseus.githubtrend20.ui.main.GithubRepo
import kotlinx.android.synthetic.main.fragment_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 const val SELECTED_GITHUB_REPO = "selected_github_repo"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
//    lateinit var mainViewModel: MainViewModel
    lateinit var selectedGithubRepo: GithubRepo
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        arguments?.let {
            selectedGithubRepo = it.getParcelable<GithubRepo>(SELECTED_GITHUB_REPO)
        }
        setupActionBarTitle()
        setupViews()
    }

    private fun setupViews() {
        repo_description.text = selectedGithubRepo.description
        owner_name.text = selectedGithubRepo.ownerName
        github_url.text = selectedGithubRepo.githubUrl
        Glide.with(requireContext())
            .load(selectedGithubRepo.avatarUrl)
            .into(avatar_url)
    }

    private fun setupActionBarTitle() {
        (requireActivity() as MainActivity).supportActionBar?.let {
            it.title = selectedGithubRepo.name
        }
    }
}
