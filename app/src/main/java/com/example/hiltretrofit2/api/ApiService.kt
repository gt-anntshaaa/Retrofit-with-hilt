package com.example.hiltretrofit2.api

import com.example.hiltretrofit2.data.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    suspend fun getEmployees(): Response<EmployeeResponse>
}