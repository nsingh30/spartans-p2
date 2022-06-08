package com.example.recipegenie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(@PrimaryKey(autoGenerate = true) var recipeId: Int?,
                  @ColumnInfo(name = "title") var title: String,
                  @ColumnInfo(name = "rYield") var rYield: String,
                  @ColumnInfo(name = "prepTime") var prepTime: String,
                  @ColumnInfo(name = "totalTime") var totalTime: String,
                  @ColumnInfo(name = "ingredients") var ingredients: String,
                  @ColumnInfo(name = "directions") var directions: String)