package com.jgtche.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun list(): Call<List<PostEntity>>

    @GET("posts")
    suspend fun listCoroutine(): Response<List<PostEntity>>
}