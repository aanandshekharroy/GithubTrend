package com.example.theseus.githubtrend20.data.api

import com.example.theseus.githubtrend20.data.api.model.GithubSearchAPIResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIManagerImp @Inject constructor(private val githubAPIService: GithubAPIService): APIManager {
    override fun fetchGithubReposFromAPI(): Single<GithubSearchAPIResponse> {
        return githubAPIService.fetchGithubRepoFromSearchEndpoint()
    }
}