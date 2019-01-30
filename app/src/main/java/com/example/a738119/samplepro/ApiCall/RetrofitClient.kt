package com.example.a738119.samplepro.ApiCall

import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    val BASE_URL:String = "http://www.google.co.in"
    var retrofit: Retrofit? = null

    fun getGitHubApiService() : GithubApiService{
        val retrofit:Retrofit = getClient(BASE_URL)
        val gitHubapiSevice : GithubApiService = retrofit.create(GithubApiService::class.java)
        return gitHubapiSevice
    }
    fun getClient(url: String?): Retrofit{

        if(retrofit==null){
            retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }
    var httpClient: OkHttpClient.Builder = OkHttpClient.Builder();
    init {
        httpClient.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder().addHeader("parameter", "value")
                    .addHeader("parameter", "value")
                    .addHeader("parameter", "value")
                    .build()
                return chain.proceed(request)
            }
        })
    }


}