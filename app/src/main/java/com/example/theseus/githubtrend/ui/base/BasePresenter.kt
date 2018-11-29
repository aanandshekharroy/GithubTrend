package com.example.theseus.githubtrend.ui.base

open class BasePresenter<V: IBaseView>: IBasePresenter<V> {
    var view:V? = null
    override fun onAttach(v: V) {
        view = v
    }

    override fun onDetach() {
        view = null
    }
}