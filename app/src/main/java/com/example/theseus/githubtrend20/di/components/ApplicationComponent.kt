package com.example.theseus.githubtrend20.di.components

import com.example.theseus.githubtrend20.GithubRepoApplication
import com.example.theseus.githubtrend20.di.modules.ApplicationModule
import com.example.theseus.githubtrend20.di.modules.MainFragmentModule
import com.example.theseus.githubtrend20.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: GithubRepoApplication)
    fun mainFragmentComponent(mainFragmentModule: MainFragmentModule):MainFragmentComponent
}