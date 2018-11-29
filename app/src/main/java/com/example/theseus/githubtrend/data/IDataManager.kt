package com.example.theseus.githubtrend.data

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.GithubTrendingRepoResponse
import io.reactivex.Single

interface IDataManager {
    fun fetchTrendingAndroidRepos(): Single<GithubTrendingRepoResponse>
}