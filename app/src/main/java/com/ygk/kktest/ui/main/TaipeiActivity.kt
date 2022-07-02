package com.ygk.kktest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ygk.kktest.R
import com.ygk.kktest.api.APIClient

class TaipeiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taipei)

        var api:APIClient = APIClient()
        api.getAttractionList(1) ;

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaipeiFragment.newInstance())
                .commitNow()
        }
    }
}