package com.ygk.kktest.model
import com.google.gson.annotations.SerializedName

data class AttractionResult (
    @SerializedName("total" ) var total : Int?            = null,
    @SerializedName("data"  ) var data  : ArrayList<Attraction> = arrayListOf()
)
