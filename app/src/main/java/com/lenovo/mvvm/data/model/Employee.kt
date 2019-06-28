package com.lenovo.mvvm.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Employee {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("employee_name")
    @Expose
    var employeeName: String? = null
    @SerializedName("employee_salary")
    @Expose
    var employeeSalary: String? = null
    @SerializedName("employee_age")
    @Expose
    var employeeAge: String? = null
    @SerializedName("profile_image")
    @Expose
    var profileImage: String? = null

}
