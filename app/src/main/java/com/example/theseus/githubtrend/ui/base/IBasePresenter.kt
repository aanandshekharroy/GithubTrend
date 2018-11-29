package com.example.theseus.githubtrend.ui.base

interface IBasePresenter<V>{
    fun onAttach(v: V)
    fun onDetach()
}