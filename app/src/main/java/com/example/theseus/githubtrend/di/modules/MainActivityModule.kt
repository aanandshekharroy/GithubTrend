package com.example.theseus.githubtrend.di.modules

import android.content.Context
import com.example.theseus.githubtrend.R
import com.example.theseus.githubtrend.di.scopes.MainActivityScope
import com.example.theseus.githubtrend.ui.main.IMainPresenter
import com.example.theseus.githubtrend.ui.main.IMainView
import com.example.theseus.githubtrend.ui.main.MainPresenter
import com.example.theseus.githubtrend.ui.main.RepoListAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.indeterminateProgressDialog

@Module
class MainActivityModule(val context:Context) {

    @Provides
    @MainActivityScope
    fun providePresenter(mainPresenter: MainPresenter<IMainView>) = mainPresenter as IMainPresenter<IMainView>

    @Provides
    @MainActivityScope
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @MainActivityScope
    fun provideRepoListAdapter() = RepoListAdapter()


    @Provides
    @MainActivityScope
    fun progressDialog() = context.indeterminateProgressDialog(context.getString(R.string.please_wait)).apply {
        hide()
    }

}