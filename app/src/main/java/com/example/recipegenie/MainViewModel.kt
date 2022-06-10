package com.example.recipegenie


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(  private val repo: RecipeRepository): ViewModel() {

    val allRecipes : LiveData<List<Recipe>>?

    init {
//        repo = RecipeRepository(app)
        allRecipes = repo.getAllRecipes()
    }

    fun getAllRecipes() = viewModelScope.launch {
        repo.getAllRecipes()
    }

    fun insertRecipes(recipe: Recipe) = viewModelScope.launch {
        repo.insertRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe) = viewModelScope.launch {
        repo.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) = viewModelScope.launch {
        repo.deleteRecipe(recipe)
    }
}