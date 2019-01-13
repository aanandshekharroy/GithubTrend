package com.example.theseus.githubtrend20.di.modules

import android.arch.lifecycle.MutableLiveData
import com.example.theseus.githubtrend20.ui.main.GithubRepo
import com.example.theseus.githubtrend20.ui.main.GithubRepoListAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class MainFragmentModule {
    @Provides
    fun provideLiveDataForGithubRepoList() = MutableLiveData<List<GithubRepo>>()
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
    @Provides
    fun provideGithubRepoAdapter() = GithubRepoListAdapter()
    @Provides
    fun provideIsLoading() = MutableLiveData<Boolean>()
}