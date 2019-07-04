package com.lenovo.mvvm.ui.register

import android.os.Bundle
import com.lenovo.mvvm.BR
import com.lenovo.mvvm.MVVMApplication
import com.lenovo.mvvm.R
import com.lenovo.mvvm.base.BaseActivity
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.databinding.ActivityRegisterBinding
import com.lenovo.mvvm.viewmodel.RegisterViewModel
import android.app.Activity
import android.content.Intent
import java.util.*




class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(), RegisterActivityCallBack {

    private val bindingVariable: Int
        get() = BR.registerViewModel

    //private lateinit var localeCountry: Country;

    override fun onCreate(savedInstanceState: Bundle?) {
        MVVMApplication.component!!.inject(this) //Add activity to app component
        super.onCreate(savedInstanceState)
        viewModel!!.attach(this) //For attach the interface
        bindView(R.layout.activity_register)
        binding.setVariable(bindingVariable, viewModel!!) // Set the view model


    }

    override fun setEmployeesList(employeesList: List<Employee>) {
        //binding.rcyResult.adapter = EmployeeAdapter(this, employeesList)
    }


}
