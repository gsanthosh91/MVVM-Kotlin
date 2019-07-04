package com.lenovo.mvvm.data.network.response_listner

import com.lenovo.mvvm.base.IView
import com.lenovo.mvvm.data.model.Employee

interface OnRegisterListener : IView {
    fun onSuccess(employees: List<Employee>)
}