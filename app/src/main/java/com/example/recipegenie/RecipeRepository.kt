package com.example.recipegenie

import android.content.Context
import androidx.lifecycle.LiveData

class RecipeRepository (var dao: RecipeDao,var retroApiInterface: RetroApiInterface){
//    var dao:Recipedao = AppDatabase.getInstance(context)?.recipeDao()

    fun getAllRecipes(): LiveData<List<Recipe>>? {
        return dao.selectRecipe()
    }

    fun insertRecipe(recipe: Recipe) {
        dao.insertRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe) {
        dao.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) {
        dao.deleteRecipe(recipe)
    }

    fun deleteAll(){
        dao.deleteAll()
    }

    fun findRecipeWithId(search: String): List<Recipe> {

        return dao.findRecipeWithId(search)!!
    }

    fun findRecipeWithTitle(search: String): List<Recipe> {

        return dao.findRecipeWithTitle(search)!!
    }

    // insert things in an Async way
}