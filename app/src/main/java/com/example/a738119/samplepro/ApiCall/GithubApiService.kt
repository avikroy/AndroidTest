package com.example.a738119.samplepro.ApiCall

import com.example.a738119.samplepro.Interface.PhillipPayBase
import com.example.a738119.samplepro.Model.AddSubscriptionModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface GithubApiService {

    @GET("")
    fun  AddSubscriptions(@QueryMap Options:Map<String,String>): Callback<AddSubscriptionModel>

    @FormUrlEncoded
    @POST("update-badge-count")
    fun updateBadgeCount(@Field("salt") salt: String, @Field("encData") encData: String): Call<PhillipPayBase>

    @GET("article.rss")
    fun loadRSSFeed(): Call<AddSubscriptionModel>
}