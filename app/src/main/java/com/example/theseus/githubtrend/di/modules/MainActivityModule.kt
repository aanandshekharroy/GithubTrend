package com.example.theseus.githubtrend.di.modules

import com.example.theseus.githubtrend.di.scopes.MainActivityScope
import com.example.theseus.githubtrend.ui.main.IMainPresenter
import com.example.theseus.githubtrend.ui.main.IMainView
import com.example.theseus.githubtrend.ui.main.MainPresenter
import com.example.theseus.githubtrend.ui.main.RepoListAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun providePresenter(mainPresenter: MainPresenter<IMainView>) = mainPresenter as IMainPresenter<IMainView>

    @Provides
    @MainActivityScope
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @MainActivityScope
    fun provideRepoListAdapter() = RepoListAdapter()


}