package com.katkov.lolachievements.application.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {

    protected var compositeDisposable = CompositeDisposable()

    override fun onDestroy() = compositeDisposable.dispose()
}