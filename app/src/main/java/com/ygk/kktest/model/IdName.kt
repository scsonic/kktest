package com.ygk.kktest.model

import com.google.gson.annotations.SerializedName

data class IdName (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)