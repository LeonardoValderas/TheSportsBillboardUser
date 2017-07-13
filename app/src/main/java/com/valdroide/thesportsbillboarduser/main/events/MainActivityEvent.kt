package com.valdroide.thesportsbillboarduser.main.events


class MainActivityEvent {
    var error: String? = null
    var type: Int = 0
    companion object {
        val SUCCESS: Int = 0;
        val ERROR: Int = 1;
    }
}