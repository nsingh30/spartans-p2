package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoritesList : AppCompatActivity() {

    var recipeList = ArrayList<Recipe>()
    lateinit var mainViewModel: MainViewModel
    lateinit var recipeAdapter: RecipeAdapter

    lateinit var nav_add: View
    lateinit var nav_search: View
    lateinit var nav_home: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_list)

        mainViewModel = MainViewModel((application))
        mainViewModel.allRecipes?.observe(this) { recipeList ->
            getRecipes(recipeList)
        }

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView_favorites_card)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // create an adapter
        recipeAdapter = RecipeAdapter({ position -> onCardClick(position) }, recipeList)


        // take the views adapter then assign it to the custom adapter we created
        recyclerView.adapter = recipeAdapter

        nav_add = findViewById(R.id.nav_add)
        nav_add.setOnClickListener() {
            val intent = Intent(this, NewRecipeForm::class.java)
            startActivity(intent)
        }

        nav_search = findViewById(R.id.nav_search)
        nav_search.setOnClickListener {
            val myIntent = Intent(this, search_recipes::class.java)
            startActivity(myIntent)
        }
        nav_home = findViewById(R.id.nav_home)
        nav_home.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
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