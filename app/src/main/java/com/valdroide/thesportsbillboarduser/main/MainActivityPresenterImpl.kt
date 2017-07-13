package com.valdroide.thesportsbillboarduser.main

import com.valdroide.thesportsbillboarduser.lib.base.EventBus
import com.valdroide.thesportsbillboarduser.main.events.MainActivityEvent
import com.valdroide.thesportsbillboarduser.main.ui.MainActivityView
import org.greenrobot.eventbus.Subscribe

class MainActivityPresenterImpl(val view: MainActivityView, val eventBus: EventBus, val interactors: MainActivityInteractor) : MainActivityPresenter {

    override fun onRegister() {
        eventBus.register(this)
    }

    override fun onUnRegister() {
        eventBus.unregister(this)
    }

    override fun success(isSuccess: Boolean) {
        interactors.success(isSuccess)
    }

    @Subscribe
    override fun onEventMainThread(event: MainActivityEvent) {
        if (view != null) {
            when (event.type) {
                MainActivityEvent.SUCCESS -> view.success();
                MainActivityEvent.ERROR -> view.setError(event.error!!)
            }
        }
    }

}
