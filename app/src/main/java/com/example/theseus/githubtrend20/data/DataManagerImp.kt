package com.example.theseus.githubtrend20.data

import com.example.theseus.githubtrend20.data.api.APIManager
import com.example.theseus.githubtrend20.data.api.model.GithubSearchAPIResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImp @Inject constructor(private val mApiManager: APIManager): DataManager {
    override fun getGithubRepoList(): Single<GithubSearchAPIResponse> {
        return mApiManager.fetchGithubReposFromAPI().subscribeOn(Schedulers.io())
    }
}