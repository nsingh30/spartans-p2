package com.example.recipegenie

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroApiInterface {

    //Singleton
    @GET("recipelist.json")
    fun getAllRecipes(): Call<List<Recipe>>

    companion object {
        var BASE_URL = "https://ssblue18.github.io/"
        fun create() : RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}