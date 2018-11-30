package com.example.theseus.githubtrend.ui.main

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.theseus.githubtrend.GithubTrendApplication
import com.example.theseus.githubtrend.R
import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import com.example.theseus.githubtrend.di.modules.MainActivityModule
import com.example.theseus.githubtrend.ui.base.BaseActivity
import com.example.theseus.githubtrend.ui.detail.RepoDetailActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainView {
    override fun showProgressDialog() {
        mProgressDialog.show()
    }

    override fun hideErrorViews() {
        error_views.visibility = View.GONE
    }

    override fun hideProgressDialog() {
        mProgressDialog.hide()
    }

    override fun showErrorViews() {
        error_views.visibility = View.VISIBLE
    }

    override fun populateRepoList(repoList: List<RepoItem>) {
        mRepoListAdapter.updateRepoList(repoList)
    }
    @Inject
    lateinit var mPresenter: IMainPresenter<IMainView>

    @Inject
    lateinit var mRepoListAdapter: RepoListAdapter

    @Inject
    lateinit var mProgressDialog: ProgressDialog

    @Inject
    lateinit var mCompositeDisposable: CompositeDisposable
    // click listener: invoked when clicked on repo list item
    val repoClickListener = { repo: RepoItem ->
        startActivity<RepoDetailActivity>("repo" to repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as GithubTrendApplication).mApplicationComponent
                .mainActivityComponent(MainActivityModule(this)).inject(this)
        setContentView(R.layout.activity_main)
        mPresenter.onAttach(this)
        setupViews()
        Timber.d("fettching")
    }

    private fun setupViews() {
        mRepoListAdapter.mListener = repoClickListener
        repo_list.layoutManager = LinearLayoutManager(this)
        repo_list.adapter = mRepoListAdapter
        //Add throttle to button click o prevent wasteful frequent requests
        mCompositeDisposable.add(
            RxView.clicks(try_again)
                .throttleFirst(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {
                        mPresenter.fetchTrendingAndroidRepos()
                    },onError = {
                        Timber.e(it.localizedMessage)
                    }
                )
        )
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        mProgressDialog.dismiss()
        mCompositeDisposable.dispose()
        super.onDestroy()
    }
}
