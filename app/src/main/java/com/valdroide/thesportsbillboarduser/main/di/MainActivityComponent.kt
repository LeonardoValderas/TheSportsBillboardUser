package com.valdroide.thesportsbillboarduser.main.di

import com.valdroide.thesportsbillboarduser.TheSportsBillboardAppModule
import com.valdroide.thesportsbillboarduser.lib.di.LibsModule
import com.valdroide.thesportsbillboarduser.main.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainActivityModule::class, LibsModule::class, TheSportsBillboardAppModule::class))
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}
