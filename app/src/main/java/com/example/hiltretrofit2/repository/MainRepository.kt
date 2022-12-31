package com.example.hiltretrofit2.repository

import com.example.hiltretrofit2.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getEmployee() = apiHelper.getEmployees()
}