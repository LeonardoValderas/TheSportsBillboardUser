package com.valdroide.thesportsbillboarduser.main

import com.valdroide.thesportsbillboarduser.lib.base.EventBus
import com.valdroide.thesportsbillboarduser.main.events.MainActivityEvent

class MainActivityRepositoryImpl(internal var eventBus: EventBus) : MainActivityRepository {

    override fun success(isSuccess: Boolean) {
        if(isSuccess)
            post(MainActivityEvent.SUCCESS, null)
        else
            post(MainActivityEvent.ERROR, "ES ERROR")
    }

    fun post(types: Int, errors: String?) {
        var event = MainActivityEvent();
        event.type = types
        event.error = errors
        eventBus.post(event)
    }
}
