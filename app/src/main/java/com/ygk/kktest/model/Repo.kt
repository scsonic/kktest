package com.ygk.kktest.model

import android.util.Log
import com.google.gson.Gson
import com.ygk.kktest.api.RemoteDataSource
import com.ygk.kktest.api.TEST_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

class Repo @Inject constructor(){
    var TAG: String = "Repo"

    init {
        Log.i(TAG, "Create Repo")
    }

    fun doRepositoryWork() {
        Log.i(TAG, "Do some work in Repository.")
    }

    fun getData(page:Int): AttractionResult? {
        return RemoteDataSource.share.getAttractionList(page)
    }
}