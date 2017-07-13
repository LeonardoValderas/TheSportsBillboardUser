package com.valdroide.thesportsbillboarduser.main


class MainActivityInteractorImpl(internal var repository: MainActivityRepository) : MainActivityInteractor {
    override fun success(isSuccess: Boolean) {
        repository.success(isSuccess)
    }
}