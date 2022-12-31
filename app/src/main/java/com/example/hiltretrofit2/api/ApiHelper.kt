package com.example.hiltretrofit2.api

import com.example.hiltretrofit2.data.EmployeeResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getEmployees() : Response<EmployeeResponse>
}