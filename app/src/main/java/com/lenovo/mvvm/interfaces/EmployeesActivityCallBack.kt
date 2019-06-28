package com.lenovo.mvvm.interfaces

import com.lenovo.mvvm.base.IView
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel

/**
 * Created by Lenovo on 24-02-2018.
 */

interface EmployeesActivityCallBack : IView {
    fun setEmployeesList(employeesList: List<Employee>)
}
