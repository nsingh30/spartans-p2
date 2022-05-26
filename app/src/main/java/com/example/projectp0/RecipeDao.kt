package com.example.projectp0

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDao {
    // Create
    @Insert
    fun insertRecipe(recipe: Recipe)
    // Read
    @Query("select * from recipes")
    fun selectRecipe(): LiveData<List<Recipe>>

    // Update
    @Update
    fun updateRecipe(recipe: Recipe)

    // Delete
    @Delete
    fun deleteRecipe(recipe: Recipe)

    @Query("delete from recipes")
    fun deleteAll()
}