package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class search_recipes : AppCompatActivity() {

    lateinit var nav_favorites: View
    lateinit var nav_home: View
    lateinit var nav_add: View

    var recipeList = ArrayList<Recipe>()
    lateinit var mainViewModel: MainViewModel
    lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_recipes)

        mainViewModel = MainViewModel((application))
        mainViewModel.allRecipes?.observe(this) { recipeList ->
            getRecipes(recipeList)
        }

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView_search)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // create an adapter
        recipeAdapter = RecipeAdapter({ position -> onCardClick(position) }, recipeList)


        // take the views adapter then assign it to the custom adapter we created
        recyclerView.adapter = recipeAdapter

        nav_favorites = findViewById(R.id.nav_favorites)
        nav_home = findViewById(R.id.nav_home)
        nav_add = findViewById(R.id.nav_add)

        nav_favorites.setOnClickListener {
            val myIntent = Intent(this, search_recipes::class.java)
            startActivity(myIntent)
        }
        nav_home.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

        nav_add.setOnClickListener {
            val myIntent = Intent(this, NewRecipeForm::class.java)
            startActivity(myIntent)
        }


    }

    private fun onCardClick(position: Int) {
        val myIntent = Intent(this, RecipePage::class.java)
        myIntent.putExtra("title", recipeList[position].title)
        startActivity(myIntent)
    }
    private fun getRecipes(recipeList: List<Recipe>) {
        this.recipeList.clear()
        this.recipeList.addAll(recipeList)
        recipeAdapter.notifyDataSetChanged()
    }
}