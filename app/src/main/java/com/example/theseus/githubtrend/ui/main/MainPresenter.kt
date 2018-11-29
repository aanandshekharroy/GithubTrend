package com.example.theseus.githubtrend.ui.main

import com.example.theseus.githubtrend.data.IDataManager
import com.example.theseus.githubtrend.di.scopes.MainActivityScope
import com.example.theseus.githubtrend.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

@MainActivityScope
class MainPresenter<V: IMainView> @Inject constructor(val mDataManager: IDataManager, val mCompositeDisposable: CompositeDisposable)
    : BasePresenter<V>(), IMainPresenter<V> {

    override fun onAttach(v: V) {
        super.onAttach(v)
        fetchTrendingAndroidRepos()
    }

    fun fetchTrendingAndroidRepos() {
        mCompositeDisposable.add(
                mDataManager.fetchTrendingAndroidRepos()
                        .subscribeBy(
                                onSuccess = {


                                }, onError = {

                        }
                        )
        )
    }
}