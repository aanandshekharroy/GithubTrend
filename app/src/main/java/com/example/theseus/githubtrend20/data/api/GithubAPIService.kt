package com.example.theseus.githubtrend20.data.api

import com.example.theseus.githubtrend20.data.api.model.GithubSearchAPIResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GithubAPIService {
    @GET("search/repositories?q=android&sort=stars&order=desc")
    fun fetchGithubRepoFromSearchEndpoint(): Single<GithubSearchAPIResponse>
}