package com.example.theseus.githubtrend20

import android.app.Application
import com.example.theseus.githubtrend20.di.components.ApplicationComponent
import com.example.theseus.githubtrend20.di.components.DaggerApplicationComponent
import timber.log.Timber

class GithubRepoApplication: Application() {
    lateinit var mApplicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        mApplicationComponent = DaggerApplicationComponent.builder().build()
        mApplicationComponent.inject(this)
    }
}