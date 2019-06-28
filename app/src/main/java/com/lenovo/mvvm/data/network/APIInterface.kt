package com.lenovo.mvvm.data.network

import com.lenovo.mvvm.data.model.Employee
import com.lenovo.mvvm.data.model.PlacesModel

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Lenovo on 24-02-2018.
 */

interface APIInterface {
    @GET("api/v1/employees")
    fun employees(): Observable<List<Employee>>
}
