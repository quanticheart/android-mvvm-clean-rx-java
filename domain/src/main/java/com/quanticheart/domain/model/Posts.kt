package com.quanticheart.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Posts {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null
}

