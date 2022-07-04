package com.ygk.kktest.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.model.AttractionResult
import com.ygk.kktest.api.APIClient
import javax.inject.Inject

//@HiltViewModel
class MainViewModel2: ViewModel() {

    var TAG = "MainViewModel2" ;

    var currentPage:Int = 1 ;
    var listLiveData : MutableLiveData<List<Attraction>> = MutableLiveData()

    //var openItemEvent: MutableLiveData<Event<String>> = MutableLiveData()

    fun getData() {
        APIClient.share.getAttractionList(currentPage, object: APIClient.OnAttractionCallback {
            override fun onSuccess(result: AttractionResult){
                Log.e(TAG, "On Success") ;
                listLiveData.postValue(result.data)
            }
            override fun onFail(ex: Exception){
                Log.e(TAG, "On FAIL") ;
                // do something
            }
        })
//        repository.getItems(object : IRepository.ItemCallback {
//            override fun onItemsResult(items: List<Item>) {
//                viewModelScope.launch {
//                    //取得資料後放在listLiveData
//                    listLiveData.value = items
//                }
//            }
//        })
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}