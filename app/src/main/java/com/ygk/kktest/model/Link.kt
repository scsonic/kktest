package com.ygk.kktest.model

import com.google.gson.annotations.SerializedName

data class Link (
    @SerializedName("src"     ) var src     : String? = null,
    @SerializedName("subject" ) var subject : String? = null
)
