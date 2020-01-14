package com.quanticheart.model.repository.posts.entitys

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponsePosts {
    @SerializedName("_meta")
    @Expose
    var meta: Meta? = null
    @SerializedName("result")
    @Expose
    var result: List<Result>? = null

    class Edit {
        @SerializedName("href")
        @Expose
        var href: String? = null
    }

    class Links {
        @SerializedName("self")
        @Expose
        var self: Self? = null
        @SerializedName("edit")
        @Expose
        var edit: Edit? = null
    }

    class Meta {
        @SerializedName("success")
        @Expose
        var success: Boolean? = null
        @SerializedName("code")
        @Expose
        var code: Int? = null
        @SerializedName("message")
        @Expose
        var message: String? = null
        @SerializedName("totalCount")
        @Expose
        var totalCount: Int? = null
        @SerializedName("pageCount")
        @Expose
        var pageCount: Int? = null
        @SerializedName("currentPage")
        @Expose
        var currentPage: Int? = null
        @SerializedName("perPage")
        @Expose
        var perPage: Int? = null
        @SerializedName("rateLimit")
        @Expose
        var rateLimit: RateLimit? = null
    }

    class RateLimit {
        @SerializedName("limit")
        @Expose
        var limit: Int? = null
        @SerializedName("remaining")
        @Expose
        var remaining: Int? = null
        @SerializedName("reset")
        @Expose
        var reset: Int? = null
    }

    class Result {
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
        @SerializedName("_links")
        @Expose
        var links: Links? = null
    }

    class Self {
        @SerializedName("href")
        @Expose
        var href: String? = null
    }
}

