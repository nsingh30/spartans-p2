package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class RecipePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val repo: RecipeRepository by lazy {
            RecipeRepository(this)
        }

        var id: TextView = findViewById(R.id.id)
        var title: TextView = findViewById(R.id.title)
        var rYield: TextView = findViewById(R.id.r_yield)
        var prepTime: TextView = findViewById(R.id.prep_time)
        var totalTime: TextView = findViewById(R.id.total_time)
        var ingredients: TextView = findViewById(R.id.ingredients)
        var directions: TextView = findViewById(R.id.directions)

        var recipe : List<Recipe> = repo.findRecipeWithTitle(intent.getStringExtra("title").toString())
        id.text = recipe[0].recipeId.toString()
        title.text = recipe[0].title
        rYield.text = recipe[0].rYield
        prepTime.text = recipe[0].prepTime
        totalTime.text = recipe[0].totalTime
        ingredients.text = recipe[0].ingredients
        directions.text = recipe[0].directions


        val btnHome : ExtendedFloatingActionButton = findViewById(R.id.btn_home)
        btnHome.setOnClickListener{
            val intent : Intent =  Intent (this, MainActivity:: class.java)
            startActivity(intent)
        }
    }
}