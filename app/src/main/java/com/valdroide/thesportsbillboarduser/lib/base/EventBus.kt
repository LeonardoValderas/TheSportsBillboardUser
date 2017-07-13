package com.valdroide.thesportsbillboarduser.lib.base


interface EventBus{
    fun register(subscriber : Any);
    fun unregister(subscriber : Any);
    fun post(event : Any);
}
