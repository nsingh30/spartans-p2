package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class search_recipes : AppCompatActivity() {

    private lateinit var favorite_view: ImageView
    private lateinit var home_view: ImageView
    private lateinit var new_recipe_view: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_recipes)

        favorite_view = findViewById(R.id.favorite_view)
        home_view = findViewById(R.id.home_view)
        new_recipe_view = findViewById(R.id.new_recipe_view)

        favorite_view.setOnClickListener{
            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }

        home_view.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        new_recipe_view.setOnClickListener{
            val intent = Intent(this, NewRecipeForm::class.java)
            startActivity(intent)
        }
    }
}