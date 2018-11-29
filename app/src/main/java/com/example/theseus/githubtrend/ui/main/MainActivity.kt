package com.example.theseus.githubtrend.ui.main

import android.os.Bundle
import com.example.theseus.githubtrend.GithubTrendApplication
import com.example.theseus.githubtrend.R
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import com.example.theseus.githubtrend.di.modules.MainActivityModule
import com.example.theseus.githubtrend.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainView {
    override fun setRepoList(repoList: List<RepoItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    @Inject
    lateinit var mPresenter: IMainPresenter<IMainView>

    @Inject
    lateinit var mRepoListAdapter: RepoListAdapter

    // click listener: invoked when clicked on repo list item
    val repoClickListener = { repo: RepoItem ->
//        startActivity<RepoDetailActivity>("order" to order)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as GithubTrendApplication).mApplicationComponent
                .mainActivityComponent(MainActivityModule()).inject(this)
        setContentView(R.layout.activity_main)
        mPresenter.onAttach(this)
        setupViews()
    }

    private fun setupViews() {
        mRepoListAdapter.mListener = repoClickListener
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }
}
