package com.ygk.kktest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.ygk.kktest.R
import com.ygk.kktest.databinding.ActivityTaipeiBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@AndroidEntryPoint
class TaipeiActivity : AppCompatActivity() {
    var TAG: String = "TaipeiActivity"

    @Inject
    lateinit var adapter: AttractionAdapter

    @Inject
    lateinit var viewModel: MainViewModel2

    lateinit var binding: ActivityTaipeiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taipei)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_taipei)
        setContentView(binding.root) ;

        //adapter = AttractionAdapter(viewModel)
        binding.rvList.adapter = adapter
        binding.lifecycleOwner = this

        CoroutineScope(Dispatchers.IO ).launch {
            viewModel.getData()
        }

        viewModel.listLiveData.observe(this, Observer {
            Log.e(TAG, "list size=" + it.size)
            if ( it.size == 0 ){
                binding.pbLoading.visibility = View.VISIBLE
            }
            else {
                binding.pbLoading.visibility = View.GONE
                adapter.notifyDataSetChanged()
            }

        })

    }
}