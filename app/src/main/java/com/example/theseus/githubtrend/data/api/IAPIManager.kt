package com.example.theseus.githubtrend.data.api

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import io.reactivex.Single

interface IAPIManager {
    fun fetchTrendingAndroidRepos(): Single<GithubTrendingRepoResponse>
}