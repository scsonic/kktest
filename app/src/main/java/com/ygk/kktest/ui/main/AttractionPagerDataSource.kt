package com.ygk.kktest.ui.main

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ygk.kktest.api.RemoteDataSource
import com.ygk.kktest.model.Attraction

private const val START_INDEX = 1;

open class AttractionPagerDataSource<T, U>(val repo: RemoteDataSource) : PagingSource<Int, Attraction>() {
    var TAG = "AttractionPagerDataSource"

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Attraction> {
        val pos = params.key ?: START_INDEX
        val startIndex = pos * params.loadSize + 1

        val result = repo.getAttractionList((startIndex) / 30)
        if ( result != null){
            if ( startIndex > result.total!!) {
                //return LoadResult.Error(Exception("Reach end of data"))
            }
        }
        return try {
            LoadResult.Page(
                result!!.data,
                if (pos <= START_INDEX) null else pos - 1, // key before
                if (result!!.data.isNullOrEmpty()) null else pos + 1, // key next
                startIndex, // items before
                Math.max(0, result.total!! - startIndex - params.loadSize) // items after
            )
        }catch (e:Exception){
            Log.e(TAG, "Load Data FAIL error", e) ;
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Attraction>): Int? {
        TODO("Not yet implemented")
    }
}
