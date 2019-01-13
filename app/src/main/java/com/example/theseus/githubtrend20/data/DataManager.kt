package com.example.theseus.githubtrend20.data

import com.example.theseus.githubtrend20.data.api.model.GithubSearchAPIResponse
import io.reactivex.Single

interface DataManager {
    fun getGithubRepoList(): Single<GithubSearchAPIResponse>
}