package com.ygk.kktest.api

import android.util.Log
import com.google.gson.Gson
import com.ygk.kktest.model.AttractionResult
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

const val TEST_URL = "https://www.travel.taipei/open-api/zh-tw/Attractions/All?page="
const val TAG = "RemoteDataSource"

class RemoteDataSource @Inject constructor(){
    companion object {
        val share = RemoteDataSource()
    }

    interface OnAttractionCallback {
        fun onSuccess(result: AttractionResult);
        fun onFail(ex: Exception);
    }

    @Deprecated("Use Suspend")
    fun getAttractionList(page:Int, callback: OnAttractionCallback) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(TEST_URL + page)
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


    fun getAttractionList(page:Int): AttractionResult? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(TEST_URL + page)
            .addHeader("accept", "application/json")
            .build()
        Log.i(TAG, "Load Page=" + page)
        val response = client.newCall(request).execute()
        val resStr = response.body?.string()
        Log.i(TAG, "ret=" + resStr)
        val attr: AttractionResult = Gson().fromJson(resStr, AttractionResult::class.java)
        Log.i(com.ygk.kktest.api.TAG, "Attraction Result = " + attr.total)
        return attr
    }

}