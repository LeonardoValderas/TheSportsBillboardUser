package com.valdroide.thesportsbillboarduser.main.di

import android.app.Activity
import com.valdroide.thesportsbillboarduser.main.*
import com.valdroide.thesportsbillboarduser.main.ui.MainActivityView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainActivityModule (val view : MainActivityView, val activity : Activity){

    @Provides
    @Singleton
    fun provideMainActivityView(): MainActivityView {
        return this.view
    }

    @Provides
    @Singleton
    fun provideMainActivityPresenter(view:MainActivityView, eventBus:com.valdroide.thesportsbillboarduser.lib.base.EventBus, interactor: MainActivityInteractor): MainActivityPresenter {
        return MainActivityPresenterImpl(view, eventBus, interactor);
    }
    @Provides
    @Singleton
    fun provideMainActivityInteractor(repository: MainActivityRepository): MainActivityInteractor {
        return MainActivityInteractorImpl(repository);
    }
    @Provides
    @Singleton
    fun provideMainActivityRepository(eventBus:com.valdroide.thesportsbillboarduser.lib.base.EventBus): MainActivityRepository {
        return MainActivityRepositoryImpl(eventBus);
    }
}
