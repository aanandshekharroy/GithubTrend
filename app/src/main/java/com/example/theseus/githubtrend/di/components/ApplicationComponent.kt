package com.example.theseus.githubtrend.di.components


import com.example.theseus.dahmakantest.di.components.MainActivityComponent
import com.example.theseus.githubtrend.GithubTrendApplication
import com.example.theseus.githubtrend.di.modules.ApplicationModule
import com.example.theseus.githubtrend.di.modules.MainActivityModule
import com.example.theseus.githubtrend.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, NetworkModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(githubTrendApplication: GithubTrendApplication)
    fun mainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent
}