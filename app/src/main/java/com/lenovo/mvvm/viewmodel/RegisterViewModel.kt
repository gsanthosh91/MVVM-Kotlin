package com.lenovo.mvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import com.lenovo.mvvm.base.BaseViewModel
import com.lenovo.mvvm.base.IView
import com.lenovo.mvvm.data.AppDataManager
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel
import com.lenovo.mvvm.data.network.ApiHelper
import com.lenovo.mvvm.data.network.response_listner.OnEmployeeListener
import com.lenovo.mvvm.data.network.response_listner.OnRegisterListener
import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper
import com.lenovo.mvvm.interfaces.EmployeesActivityCallBack
import com.lenovo.mvvm.ui.register.RegisterActivityCallBack

import javax.inject.Inject

/**
 * Created by Lenovo on 24-02-2018.
 */

class RegisterViewModel @Inject
constructor() : BaseViewModel<RegisterActivityCallBack>(), OnRegisterListener {
    @Inject
    lateinit var appDataManager: AppDataManager

    fun fetchEmployees() {
        setIsLoading(true)
        compositeDisposable.add(appDataManager.apiHelper.employees(this))
    }


    override fun onSuccess(employees: List<Employee>) {
        view!!.setEmployeesList(employees)
        setIsLoading(false)
    }
}
