package com.ygk.kktest.api

import android.util.Log
import com.google.gson.Gson
import com.ygk.kktest.model.AttractionResult
import okhttp3.*
import java.io.IOException

const val TEST_URL = "https://www.travel.taipei/open-api/zh-tw/Attractions/All?page=1"
const val TAG = "APIClient"

class APIClient {
    companion object {
        val share = APIClient()
    }

    interface OnAttractionCallback {
        fun onSuccess(result: AttractionResult);
        fun onFail(ex: Exception);
    }

    fun getAttractionList(page:Int, callback: OnAttractionCallback) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(TEST_URL)
            .addHeader("accept", "application/json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFail(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val resStr = response.body?.string()
                Log.i(TAG, "ret=" + resStr)
                val result: AttractionResult = Gson().fromJson(resStr, AttractionResult::class.java)
                Log.i(TAG, "Attraction Result = " + result.total)
                callback.onSuccess(result)
            }
        })
    }
}