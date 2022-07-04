package com.ygk.kktest.model

import android.util.Log
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