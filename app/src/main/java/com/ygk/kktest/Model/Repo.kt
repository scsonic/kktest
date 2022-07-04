package com.ygk.kktest.Model

import android.util.Log
import androidx.lifecycle.LiveData
import com.ygk.kktest.api.APIClient

class Repo{
    var TAG: String = "TaipeiActivity"

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