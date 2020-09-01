package com.rogok.recyclerviewwithretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rogok.recyclerviewwithretrofit.adapter.MyAdapter
import com.rogok.recyclerviewwithretrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ACTIVITYCONTEXT = this
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter(ACTIVITYCONTEXT) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUser()
        viewModel.myResponse3.observe(this, Observer { response ->
            //Log.d("Response", response.data.toString())
            response?.let {
                myAdapter.setData(response.data)
            }
        })
    }

    private fun setupRecyclerView() {
        recycler_view.adapter = myAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}