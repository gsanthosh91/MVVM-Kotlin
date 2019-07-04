package com.lenovo.mvvm.ui.register

import com.lenovo.mvvm.base.IView
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel

/**
 * Created by Lenovo on 24-02-2018.
 */

interface RegisterActivityCallBack : IView {
    fun setEmployeesList(employeesList: List<Employee>)
}
