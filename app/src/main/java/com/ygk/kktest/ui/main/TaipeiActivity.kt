package com.ygk.kktest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ygk.kktest.Model.AttractionResult
import com.ygk.kktest.R
import com.ygk.kktest.api.APIClient
import com.ygk.kktest.api.APIClient.OnAttractionCallback
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@AndroidEntryPoint
class TaipeiActivity : AppCompatActivity() {

    var TAG: String = "TaipeiActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taipei)

        //APIClient.share.getAttractionList() ;

        APIClient.share.getAttractionList(1, object: APIClient.OnAttractionCallback {
            override fun onSuccess(result: AttractionResult){
                Log.e(TAG, "On Success") ;
            }
            override fun onFail(ex: Exception){
                Log.e(TAG, "On FAIL") ;
            }
        })

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaipeiFragment.newInstance())
                .commitNow()
        }
    }
}