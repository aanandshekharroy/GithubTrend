package com.example.theseus.githubtrend.data.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class APIManager @Inject constructor(val mAPIService: APIService) : IAPIManager {
    override fun fetchTrendingAndroidRepos() = mAPIService.fetchTrendingAndroidReposFromGithub()
}