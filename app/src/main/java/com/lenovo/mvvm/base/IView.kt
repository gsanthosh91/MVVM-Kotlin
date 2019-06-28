package com.lenovo.mvvm.base

/**
 * View part of MVVM, the activities and fragment implement this
 * and is is used for interaction between ViewModel and Activities/Fragments
 */

interface IView {
    fun onError(throwable: Throwable)
}
