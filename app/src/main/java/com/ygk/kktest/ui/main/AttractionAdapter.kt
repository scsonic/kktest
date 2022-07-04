package com.ygk.kktest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.databinding.RecycleviewItemBinding

class AttractionAdapter(private val viewModel: MainViewModel2):
    RecyclerView.Adapter<AttractionAdapter.ViewHolder>(){

    var list: List<Attraction>? = viewModel.listLiveData.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list!![position]
        holder.bind(viewModel, item)
    }

    override fun getItemCount(): Int {
        return list?.count() ?: 0
    }

    class ViewHolder private constructor(private val binding: RecycleviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MainViewModel2, attr: Attraction) {

            binding.viewModel = viewModel
            binding.attr = attr // need clean project
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecycleviewItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}