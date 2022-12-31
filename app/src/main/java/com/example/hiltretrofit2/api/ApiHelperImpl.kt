package com.example.hiltretrofit2.api

import com.example.hiltretrofit2.data.EmployeeResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getEmployees(): Response<EmployeeResponse> {
        return apiService.getEmployees()
    }
}