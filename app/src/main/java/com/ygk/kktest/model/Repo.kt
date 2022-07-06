package com.ygk.kktest.model

import android.util.Log
import com.ygk.kktest.api.APIClient
import javax.inject.Inject

class Repo @Inject constructor(){
    var TAG: String = "Repo"

    init {
        Log.i(TAG, "Create Repo")
    }
    fun doRepositoryWork() {
        Log.i(TAG, "Do some work in Repository.")
    }

    suspend fun getAttraction(page:Int) {
        APIClient.share.getAttractionList(1, object: APIClient.OnAttractionCallback {
            override fun onSuccess(result: AttractionResult){
                Log.e(TAG, "On Success") ;
            }
            override fun onFail(ex: Exception){
                Log.e(TAG, "On FAIL") ;
            }
        })
    }
}