package com.example.addatwentyfour.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.addatwentyfour.R
import com.example.addatwentyfour.adapter.MyAdapter
import com.example.addatwentyfour.databinding.ActivityMainBinding
import com.example.addatwentyfour.model.UserDataModel
import com.example.addatwentyfour.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.adapter = adapter
        initObserver()
    }


    private fun initObserver() {
        viewModel.userData.observe(this, {
            binding.progress.visibility = View.GONE
            adapter.updateData(it.data as ArrayList<UserDataModel>)
        })
    }
}