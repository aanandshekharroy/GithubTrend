package com.example.theseus.githubtrend.ui.main

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import com.example.theseus.githubtrend.ui.base.IBaseView

interface IMainView: IBaseView {
    fun setRepoList(repoList: List<RepoItem>)
}