package com.example.recipegenie.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.recipegenie.RecipeResults
import com.example.recipegenie.model.RecipeRepository
import com.example.recipegenie.model.Recipe
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val repo: RecipeRepository
    val allRecipes : LiveData<List<Recipe>>?

    init {
        repo = RecipeRepository(app)
        allRecipes = repo.getAllRecipes()
    }

    fun getSearchResults(offset: Int, limit: Int, tags: String, search: String)
    = viewModelScope.launch {

        repo.getSearchResults(offset, limit, tags, search)
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