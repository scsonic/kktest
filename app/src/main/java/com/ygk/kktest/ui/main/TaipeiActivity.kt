package com.ygk.kktest.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ygk.kktest.R
import com.ygk.kktest.databinding.ActivityTaipeiBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaipeiActivity : AppCompatActivity() {

    var TAG: String = "TaipeiActivity"
    var binding: ActivityTaipeiBinding? = null
    //private lateinit var viewDataBinding: ActivityTaipeiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taipei)

        //APIClient.share.getAttractionList() ;

//        APIClient.share.getAttractionList(1, object: APIClient.OnAttractionCallback {
//            override fun onSuccess(result: AttractionResult){
//                Log.e(TAG, "On Success") ;
//            }
//            override fun onFail(ex: Exception){
//                Log.e(TAG, "On FAIL") ;
//            }
//        })


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaipeiFragment.newInstance())
                .commitNow()
        }
    }
}