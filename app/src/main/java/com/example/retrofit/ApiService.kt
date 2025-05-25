package com.example.retrofit

// ApiService.kt
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<Post>
}
