package com.ygk.kktest.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.model.AttractionResult
import com.ygk.kktest.api.APIClient
import com.ygk.kktest.model.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@ActivityRetainedScoped
class MainViewModel2 @Inject constructor(
    private val repository: Repo
) : ViewModel() {

    var TAG = "MainViewModel2" ;

    var currentPage:Int = 1 ;
    var listLiveData : MutableLiveData<List<Attraction>> = MutableLiveData()

    init {
        Log.i(TAG, "MainViewModel2 init")
    }
    //var openItemEvent: MutableLiveData<Event<String>> = MutableLiveData()
    fun doWork() {
        repository.doRepositoryWork()
    }

    suspend fun getData() {
        //viewModelScope.launch {
            val attr:AttractionResult? = APIClient.share.getAttractionList(currentPage)
            if ( attr != null ) {
                listLiveData.postValue(attr.data)
            }
        //}

//        APIClient.share.getAttractionList(currentPage, object: APIClient.OnAttractionCallback {
//            override fun onSuccess(result: AttractionResult){
//                Log.e(TAG, "On Success") ;
//                listLiveData.postValue(result.data)
//            }
//            override fun onFail(ex: Exception){
//                Log.e(TAG, "On FAIL") ;
//                // do something
//            }
//        })
    }
}
