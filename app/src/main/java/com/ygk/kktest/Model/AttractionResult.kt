package com.ygk.kktest.Model
import com.google.gson.annotations.SerializedName
import org.w3c.dom.Attr

data class AttractionResult (
    @SerializedName("total" ) var total : Int?            = null,
    @SerializedName("data"  ) var data  : ArrayList<Attraction> = arrayListOf()
)
