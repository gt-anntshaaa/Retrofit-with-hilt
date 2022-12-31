package com.example.hiltretrofit2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltretrofit2.data.EmployeeResponse
import com.example.hiltretrofit2.other.Resource
import com.example.hiltretrofit2.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepository) : ViewModel(){
    private val _res = MutableLiveData<EmployeeResponse>()
    val res: LiveData<EmployeeResponse> = _res

    init {
        getEmployee()
    }

    private fun getEmployee() = viewModelScope.launch(Dispatchers.Main) {
        repo.getEmployee().let {
            try{
                _res.postValue(it.body())
            }catch (e: Exception){
                e.stackTrace
            }

        }
    }
}