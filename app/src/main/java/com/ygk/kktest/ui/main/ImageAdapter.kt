package com.ygk.kktest.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ygk.kktest.R
import com.ygk.kktest.databinding.RecycleviewImageItemBinding
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.databinding.RecycleviewItemBinding
import com.ygk.kktest.model.Images
import javax.inject.Inject

class ImageAdapter @Inject constructor (val attr: Attraction):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    var TAG = "ImageAdapter" ;

    init {
        Log.i(TAG, "ImageAdapter init")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = attr.images.get(position) ;
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return attr.images.size
    }

    class ViewHolder private constructor(public val binding: RecycleviewImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Images) {
            binding.attrImage = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecycleviewImageItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}
