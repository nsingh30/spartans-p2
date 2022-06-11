package com.example.recipegenie.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipegenie.RetrofitClient

class RecipeRepository(context: Context) {

    var db: RecipeDao? = AppDatabase.getInstance(context)?.recipeDao()
    var retrofitClient = RetrofitClient.create()

    // Gets recipes from API
    suspend fun getSearchResults(offset: Int, limit: Int, tags: String, q: String)
            : LiveData<List<Recipe>>? {

        return retrofitClient.getSearchResults(offset, limit, tags, q)
    }

    // Gets recipes from Room DB
    fun getAllRecipes(): LiveData<List<Recipe>>? {

        return db?.selectRecipe()
    }

    fun insertRecipe(recipe: Recipe) {
        db?.insertRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe) {
        db?.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) {
        db?.deleteRecipe(recipe)
    }

    fun deleteAll() {
        db?.deleteAll()
    }

    fun findRecipeWithId(search: String): List<Recipe> {

        return db?.findRecipeWithId(search)!!
    }

    fun findRecipeWithTitle(search: String): List<Recipe> {

        return db?.findRecipeWithTitle(search)!!
    }

    // insert things in an Async way
}