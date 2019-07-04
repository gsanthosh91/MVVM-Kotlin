package com.lenovo.mvvm.data.network

import com.lenovo.mvvm.base.IView
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel
import com.lenovo.mvvm.data.network.response_listner.OnEmployeeListener
import com.lenovo.mvvm.data.network.response_listner.OnRegisterListener
import com.lenovo.mvvm.viewmodel.EmployeeViewModel

import io.reactivex.disposables.Disposable

interface ApiHelper {

    fun employees(listener: OnEmployeeListener): Disposable
    fun employees(listener: OnRegisterListener): Disposable

}
