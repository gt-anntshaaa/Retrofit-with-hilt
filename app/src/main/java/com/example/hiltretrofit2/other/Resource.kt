package com.example.hiltretrofit2.other

data class Resource<out T>(
    val data: T?,
)
