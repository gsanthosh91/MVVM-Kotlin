package com.lenovo.mvvm.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean

import java.lang.ref.WeakReference

import io.reactivex.disposables.CompositeDisposable

/**
 *
 *
 */

open class BaseViewModel<T : IView> protected constructor() : ViewModel() {

    protected var compositeDisposable: CompositeDisposable
    protected var view: T? = null
    var isLoading = ObservableBoolean(true)

    init {
        compositeDisposable = CompositeDisposable()
    }

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        view = null
    }

    fun clearSubscriptions() {
        compositeDisposable.clear()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun onError(throwable: Throwable) {
        view!!.onError(throwable)
        setIsLoading(false)
    }
}
