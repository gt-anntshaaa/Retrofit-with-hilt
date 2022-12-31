package com.example.hiltretrofit2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hiltretrofit2.data.EmployeeResponse
import com.example.hiltretrofit2.databinding.ActivityMainBinding
import com.example.hiltretrofit2.ui.adapter.EmployeeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmployeeAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EmployeeAdapter()
        binding.rvEmployees.adapter = adapter

        viewModel.res.observe(this, Observer {
            it.data.let {
                adapter.sumbit(it)
            }
        })

    }
}