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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taipei)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TaipeiFragment.newInstance())
                .commitNow()
        }
    }
}