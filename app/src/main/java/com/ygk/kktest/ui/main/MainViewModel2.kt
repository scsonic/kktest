package com.ygk.kktest.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ygk.kktest.Model.Attraction
import com.ygk.kktest.Model.AttractionResult
import com.ygk.kktest.api.APIClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel2 @Inject constructor(
    private val state: SavedStateHandle
): ViewModel() {

    var TAG = "MainViewModel2" ;

    var currentPage:Int = 1 ;
    var listLiveData : MutableLiveData<List<Attraction>> = MutableLiveData()
    //取資料
    private fun getData() {

        APIClient.share.getAttractionList(currentPage, object: APIClient.OnAttractionCallback {
            override fun onSuccess(result: AttractionResult){
                Log.e(TAG, "On Success") ;
            }
            override fun onFail(ex: Exception){
                Log.e(TAG, "On FAIL") ;
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
