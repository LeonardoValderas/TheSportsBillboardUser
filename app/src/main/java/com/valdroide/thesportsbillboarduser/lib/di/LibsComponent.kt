package com.valdroide.thesportsbillboarduser.lib.di

import com.valdroide.thesportsbillboarduser.TheSportsBillboardAppModule
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(LibsModule::class, TheSportsBillboardAppModule::class))
interface LibsComponent{
}
