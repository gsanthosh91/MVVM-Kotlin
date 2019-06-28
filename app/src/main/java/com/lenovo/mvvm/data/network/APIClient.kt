package com.lenovo.mvvm.data.network

import com.lenovo.mvvm.data.network.response_listner.OnEmployeeListener

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class APIClient @Inject
constructor() : ApiHelper {
    @Inject
    lateinit var apiInterface: APIInterface

    override fun employees(listener: OnEmployeeListener): Disposable {
        return apiInterface.employees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listener.onSuccess(it) },
                        { listener.onError(it) })
    }
}
