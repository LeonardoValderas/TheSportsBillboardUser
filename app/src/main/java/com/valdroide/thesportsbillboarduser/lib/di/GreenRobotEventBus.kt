package com.valdroide.thesportsbillboarduser.lib.di

import com.valdroide.thesportsbillboarduser.lib.base.EventBus

class GreenRobotEventBus : EventBus {
    var eventBus: org.greenrobot.eventbus.EventBus? = null;

    constructor() {
        eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    override fun register(subscriber: Any) {
        eventBus!!.register(subscriber);
    }

    override fun unregister(subscriber: Any) {
        eventBus!!.unregister(subscriber); }

    override fun post(event: Any) {
        eventBus!!.post(event);
    }
}
