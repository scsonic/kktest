package com.ygk.kktest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ygk.kktest.R
import com.ygk.kktest.databinding.FragmentMain2Binding
import com.ygk.kktest.databinding.RecycleviewItemBinding

class TaipeiFragment : Fragment() {
    companion object {
        fun newInstance() = TaipeiFragment()
    }

    var TAG: String = "TaipeiFragment"
    private lateinit var adapter: AttractionAdapter
    private lateinit var viewModel: MainViewModel2
    private lateinit var binding: FragmentMain2Binding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main2, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel2::class.java)

        adapter = AttractionAdapter(viewModel)
        binding.rvList.adapter = adapter
        viewModel.getData()
        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "list size=" + it.size)
            adapter.notifyDataSetChanged()
        })
    }

}