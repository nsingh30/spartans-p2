package com.example.recipegenie


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipegenie.model.Recipe
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitClient {

    @Headers(
        "X-RapidAPI-Host: tasty.p.rapidapi.com",
        "X-RapidAPI-Key: db75eb83a9msh93dbb46be42c052p101d6djsn9c315c55bed5"
    )
    @GET("recipes/list")
    suspend fun getSearchResults(
        @Query("from") offset: Int, @Query("size") limit: Int,
        @Query("tags") tags: String, @Query("q") search: String
    ): Response<RecipeResults>

    companion object {
        var BASE_URL = "https://tasty.p.rapidapi.com/"

        fun create(): RetrofitClient {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(RetrofitClient::class.java)
        }
    }
}