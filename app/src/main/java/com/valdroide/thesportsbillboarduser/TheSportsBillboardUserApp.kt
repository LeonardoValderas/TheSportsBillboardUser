package com.valdroide.thesportsbillboarduser

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.valdroide.thesportsbillboarduser.lib.di.LibsModule
import com.raizlabs.android.dbflow.config.FlowManager
import com.valdroide.thesportsbillboarduser.main.di.DaggerMainActivityComponent
import com.valdroide.thesportsbillboarduser.main.di.MainActivityComponent
import com.valdroide.thesportsbillboarduser.main.di.MainActivityModule
import com.valdroide.thesportsbillboarduser.main.ui.MainActivityView


class TheSportsBillboardUserApp : Application() {

    private var libsModule: LibsModule? = null
    private var theSportsBillboardAppModule: TheSportsBillboardAppModule? = null

    override fun onCreate() {
        super.onCreate()
        initModules()
        initDB()
        Stetho.initializeWithDefaults(this);
    }
    private fun initModules() {
        libsModule = LibsModule()
        theSportsBillboardAppModule = TheSportsBillboardAppModule(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        DBTearDown()
    }

    private fun DBTearDown() {
        FlowManager.destroy()
    }

    private fun initDB() {
        FlowManager.init(this)
    }

    fun getMainActivityComponent(view: MainActivityView, activity : Activity): MainActivityComponent {
        return DaggerMainActivityComponent
                .builder()
                .theSportsBillboardAppModule(theSportsBillboardAppModule)
                .libsModule(LibsModule(activity))
                .mainActivityModule(MainActivityModule(view,activity))
                .build()
    }

}
