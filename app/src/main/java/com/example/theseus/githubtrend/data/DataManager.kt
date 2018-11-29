package com.example.theseus.githubtrend.data

import com.example.theseus.githubtrend.data.api.IAPIManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(val mAPIManager: IAPIManager): IDataManager {
    override fun fetchTrendingAndroidRepos() = mAPIManager.fetchTrendingAndroidRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}