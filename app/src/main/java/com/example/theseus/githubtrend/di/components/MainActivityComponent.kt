package com.example.theseus.dahmakantest.di.components

import com.example.theseus.githubtrend.di.modules.MainActivityModule
import com.example.theseus.githubtrend.di.scopes.MainActivityScope
import com.example.theseus.githubtrend.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
@MainActivityScope
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}