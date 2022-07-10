package com.ygk.kktest.ui.main

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.ygk.kktest.model.Attraction
import com.ygk.kktest.model.AttractionResult
import com.ygk.kktest.api.RemoteDataSource
import com.ygk.kktest.model.Repo
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@ActivityRetainedScoped
class MainViewModel2 @Inject constructor(
    val repository: Repo
) : ViewModel() {

    var TAG = "MainViewModel2" ;

    var currentPage:Int = 1 ;
    var listLiveData : MutableLiveData<List<Attraction>> = MutableLiveData()

    init {
        Log.i(TAG, "MainViewModel2 init")
    }
    //var openItemEvent: MutableLiveData<Event<String>> = MutableLiveData()

    fun openItem(item:Attraction){
        Log.i(TAG, "You Press:" + item.name)
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            var attr:AttractionResult? = repository.getData(currentPage);
            if ( attr != null ) {
                listLiveData.postValue(attr.data)
            }
        }
    }

    var attractions = Pager(config = PagingConfig(
        pageSize = 30
        , enablePlaceholders = false
        , initialLoadSize = 30
    ), pagingSourceFactory = { AttractionPagerDataSource<Any, Any?>(repository.remote) }).flow

}
