package com.ygk.kktest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ygk.kktest.R

class TaipeiFragment : Fragment() {
    companion object {
        fun newInstance() = TaipeiFragment()
    }

    var TAG: String = "TaipeiFragment"
    private lateinit var adapter: AttractionAdapter
    private lateinit var viewModel: MainViewModel2


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel2::class.java)

        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            Log.e(TAG, "list size=" + it.size)
        })

    }

}