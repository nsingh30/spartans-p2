package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoritesList : AppCompatActivity() {

//    var recipeList = ArrayList<Recipe>()
//    lateinit var mainViewModel: MainViewModel
//    lateinit var recipeAdapter: RecipeAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_favorites_list)
//
//        mainViewModel = MainViewModel((application))
//        mainViewModel.allRecipes?.observe(this) { recipeList ->
//            getRecipes(recipeList)
//        }
//
//        var recyclerView: RecyclerView = findViewById(R.id.recycler_view)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // create an adapter
//        recipeAdapter = RecipeAdapter({ position -> onCardClick(position) }, recipeList)
//
//
//        // take the views adapter then assign it to the custom adapter we created
//        recyclerView.adapter = recipeAdapter
//
//        val btnAdd: FloatingActionButton = findViewById(R.id.btn_add)
//        btnAdd.setOnClickListener() {
//            val intent = Intent(this, NewRecipeForm::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun onCardClick(position: Int) {
//        val myIntent = Intent(this, RecipePage::class.java)
//        myIntent.putExtra("title", recipeList[position].title)
//        startActivity(myIntent)
//    }
//
//    private fun getRecipes(recipeList: List<Recipe>) {
//        this.recipeList.clear()
//        this.recipeList.addAll(recipeList)
//        recipeAdapter.notifyDataSetChanged()
//    }
}