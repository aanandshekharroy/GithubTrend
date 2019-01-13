package com.example.theseus.githubtrend20.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.theseus.githubtrend20.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mDataManager: DataManager,
    val githubRepo: MutableLiveData<List<GithubRepo>>,
    private val mCompositeDisposable: CompositeDisposable,
    val isLoading: MutableLiveData<Boolean>,
    val isDataFetchSuccessful: MutableLiveData<Boolean>): ViewModel() {
    init {
        fetchGithubRepo()
    }

    fun fetchGithubRepo() {
        isLoading.postValue(true)
        mCompositeDisposable.add(
            mDataManager.getGithubRepoList()
                .map {
                    it.items.map {
                        it.toGithubRepo()
                    }
                }
                .subscribeBy(
                    onSuccess = {
                        githubRepo.postValue(it)
                        isLoading.postValue(false)
                        isDataFetchSuccessful.postValue(true)
                    }, onError = {
                        isLoading.postValue(false)
                        isDataFetchSuccessful.postValue(false)
                        Timber.e(it.localizedMessage)
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }
}
