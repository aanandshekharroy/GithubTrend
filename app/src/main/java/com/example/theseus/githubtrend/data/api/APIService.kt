package com.example.theseus.githubtrend.data.api

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import io.reactivex.Single
import retrofit2.http.GET

interface APIService {
    @GET("search/repositories?q=android&sort=stars&order=desc")
    fun fetchTrendingAndroidReposFromGithub(): Single<GithubTrendingRepoResponse>
}