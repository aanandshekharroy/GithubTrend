package com.example.theseus.githubtrend.ui.main

import com.example.theseus.githubtrend.data.api.model.TrendingAPIResponse.RepoItem
import com.example.theseus.githubtrend.ui.base.IBaseView

interface IMainView: IBaseView {
    fun populateRepoList(repoList: List<RepoItem>)
    fun showProgressDialog()
    fun hideErrorViews()
    fun hideProgressDialog()
    fun showErrorViews()
}