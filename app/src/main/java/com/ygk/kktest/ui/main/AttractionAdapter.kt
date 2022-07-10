package com.ygk.kktest.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ygk.kktest.R
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.databinding.RecycleviewItemBinding
import javax.inject.Inject

class AttractionAdapter @Inject constructor (val viewModel: MainViewModel2):
    PagingDataAdapter<Attraction, AttractionAdapter.ViewHolder>(AttractionDiffCallback())
{
    var TAG = "AttractionAdapter" ;

    init {
        Log.i(TAG, "AttractionAdapter init")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(viewModel, item)
        }
    }

//    override fun getItemCount(): Int {
//        return viewModel.listLiveData.value?.size ?: 0;
//    }

    class ViewHolder private constructor(public val binding: RecycleviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MainViewModel2, attr: Attraction) {
            binding.viewModel = viewModel
            binding.attr = attr // need clean project
            binding.imageAdapter = ImageAdapter(attr)
            binding.rvImageList.adapter = binding.imageAdapter
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


class AttractionDiffCallback: DiffUtil.ItemCallback<Attraction>() {
    override fun areItemsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
        return oldItem == newItem
    }
}


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_image_24)
        .error(R.drawable.ic_baseline_image_not_supported_24)
        .centerCrop()
        .into(imageView)
}