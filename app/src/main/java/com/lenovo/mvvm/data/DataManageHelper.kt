/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lenovo.mvvm.data


import com.lenovo.mvvm.data.network.ApiHelper
import com.lenovo.mvvm.data.sharedpref.SharedPrefsHelper

/**
 * Created by gaura on 22-08-2017.
 */

interface DataManageHelper {
    val apiHelper: ApiHelper

    val loggedInMode: Boolean?

    fun clear()

    fun setLoggedIn()

}
