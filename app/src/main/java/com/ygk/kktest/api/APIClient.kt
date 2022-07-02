package com.ygk.kktest.api

import android.util.Log
import com.google.gson.Gson
import com.ygk.kktest.Model.AttractionResult
import okhttp3.*
import java.io.IOException

const val TEST_URL = "https://www.travel.taipei/open-api/zh-tw/Attractions/All?page=1"
const val TAG = "APIClient"

public class APIClient {
    fun getAttractionList(page:Int) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(TEST_URL)
            .addHeader("accept", "application/json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("HKT", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val resStr = response.body?.string()
                Log.i(TAG, "ret=" + resStr)
                val result: AttractionResult = Gson().fromJson(resStr, AttractionResult::class.java)
                Log.i(TAG, "Attraction Result = " + result.total)

//                for (item in posts) {
//                    Log.d("HKT", "id: " + item.id)
//                    Log.d("HKT", "title: " + item.title)
//                    Log.d("HKT", "body: " + item.body)
//                    Log.d("HKT", "userId: " + item.userId)
//                }
            }
        })
    }
}