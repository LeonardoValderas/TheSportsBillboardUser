package com.valdroide.thesportsbillboarduser.main

import com.valdroide.thesportsbillboarduser.main.events.MainActivityEvent


interface MainActivityPresenter {
    fun onRegister();
    fun onUnRegister();
    fun onEventMainThread(event: MainActivityEvent)
    fun success(isSuccess : Boolean)
}
