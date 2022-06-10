package com.example.recipegenie.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recipegenie.model.RecipeRepository
import com.example.recipegenie.model.Recipe
import kotlinx.coroutines.launch

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val repo: RecipeRepository
    val allRoomRecipes : LiveData<List<Recipe>>?
    val allSearchResults: LiveData<List<Recipe>>?


    init {
        repo = RecipeRepository(app)
        allRoomRecipes = repo.getAllRoomRecipes()
        allSearchResults = getSearchResults()
    }

    fun getSearchResults() :LiveData<List<Recipe>>? {

    return allSearchResults
    }

    fun getAllRoomRecipes() = viewModelScope.launch {
        repo.getAllRoomRecipes()
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