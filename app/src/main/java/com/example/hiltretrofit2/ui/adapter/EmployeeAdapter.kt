package com.example.hiltretrofit2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltretrofit2.data.EmployeeResponse
import com.example.hiltretrofit2.databinding.EmployeeItemBinding

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    private val item: MutableList<EmployeeResponse.Employee> = mutableListOf()

    inner class EmployeeViewHolder(private val binding: EmployeeItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: EmployeeResponse.Employee){
            binding.tvName.text = item.employee_name
            binding.tvAge.text = item.employee_age.toString()
            binding.tvSalary.text = item.employee_salary.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun sumbit(data: List<EmployeeResponse.Employee>){
        item.apply {
            addAll(data)
            notifyDataSetChanged()
        }
    }

}