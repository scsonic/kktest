package com.ygk.kktest.Model

import com.google.gson.annotations.SerializedName

data class Images (
    @SerializedName("src"     ) var src     : String? = null,
    @SerializedName("subject" ) var subject : String? = null,
    @SerializedName("ext"     ) var ext     : String? = null
)
