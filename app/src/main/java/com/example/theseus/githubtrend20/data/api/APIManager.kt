package com.example.theseus.githubtrend20.data.api

import com.example.theseus.githubtrend20.data.api.model.GithubSearchAPIResponse
import io.reactivex.Single

interface APIManager {
    fun fetchGithubReposFromAPI(): Single<GithubSearchAPIResponse>
}