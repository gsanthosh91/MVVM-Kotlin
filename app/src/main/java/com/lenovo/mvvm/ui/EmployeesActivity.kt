package com.lenovo.mvvm.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.lenovo.mvvm.*

import com.lenovo.mvvm.base.BaseActivity
import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel
import com.lenovo.mvvm.databinding.ActivityEmployeesBinding
import com.lenovo.mvvm.interfaces.EmployeesActivityCallBack
import com.lenovo.mvvm.viewmodel.EmployeeViewModel
import java.util.ArrayList
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.Toast
import com.lenovo.mvvm.data.AppDataManager
import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper
import com.lenovo.mvvm.di.modules.ContextModule
import javax.inject.Inject


class EmployeesActivity : BaseActivity<ActivityEmployeesBinding, EmployeeViewModel>(), EmployeesActivityCallBack {

    private val bindingVariable: Int
        get() = BR.employeesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        MVVMApplication.component!!.inject(this) //Add activity to app component
        super.onCreate(savedInstanceState)
        viewModel!!.attach(this) //For attach the interface

        bindView(R.layout.activity_employees)
        binding.setVariable(bindingVariable, viewModel!!) // Set the view model

        viewModel!!.fetchEmployees()
        binding.rcyResult.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    override fun setEmployeesList(employeesList: List<Employee>) {
        binding.rcyResult.adapter = EmployeeAdapter(this, employeesList)
    }

}
