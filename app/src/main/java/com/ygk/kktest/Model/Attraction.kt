package com.ygk.kktest.Model

import com.google.gson.annotations.SerializedName

data class Attraction (
    @SerializedName("id"            ) var id           : Int?                = null,
    @SerializedName("name"          ) var name         : String?             = null,
    @SerializedName("name_zh"       ) var nameZh       : String?             = null,
    @SerializedName("open_status"   ) var openStatus   : Int?                = null,
    @SerializedName("introduction"  ) var introduction : String?             = null,
    @SerializedName("open_time"     ) var openTime     : String?             = null,
    @SerializedName("zipcode"       ) var zipcode      : String?             = null,
    @SerializedName("distric"       ) var distric      : String?             = null,
    @SerializedName("address"       ) var address      : String?             = null,
    @SerializedName("tel"           ) var tel          : String?             = null,
    @SerializedName("fax"           ) var fax          : String?             = null,
    @SerializedName("email"         ) var email        : String?             = null,
    @SerializedName("months"        ) var months       : String?             = null,
    @SerializedName("nlat"          ) var nlat         : Double?             = null,
    @SerializedName("elong"         ) var elong        : Double?             = null,
    @SerializedName("official_site" ) var officialSite : String?             = null,
    @SerializedName("facebook"      ) var facebook     : String?             = null,
    @SerializedName("ticket"        ) var ticket       : String?             = null,
    @SerializedName("remind"        ) var remind       : String?             = null,
    @SerializedName("staytime"      ) var staytime     : String?             = null,
    @SerializedName("modified"      ) var modified     : String?             = null,
    @SerializedName("url"           ) var url          : String?             = null,
    @SerializedName("category"      ) var category     : ArrayList<IdName>   = arrayListOf(),
    @SerializedName("target"        ) var target       : ArrayList<IdName>   = arrayListOf(),
    @SerializedName("service"       ) var service      : ArrayList<IdName>   = arrayListOf(),
    @SerializedName("friendly"      ) var friendly     : ArrayList<IdName>   = arrayListOf(),
    @SerializedName("images"        ) var images       : ArrayList<Images>   = arrayListOf(),

    // ERROR no example data about files field: []
    // @SerializedName("files"         ) var files        : ArrayList<String>   = arrayListOf(),
    @SerializedName("links"         ) var links        : ArrayList<Link>   = arrayListOf()

)