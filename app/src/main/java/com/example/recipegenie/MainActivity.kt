package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.projectp0.R


class MainActivity : AppCompatActivity() {

    var recipeList = ArrayList<Recipe>()
    var vm = MainViewModel
    lateinit var adapter:RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_category)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
            false)

        adapter = RecipeAdapter({position -> onCardClick(position)}, recipeList)
        recyclerView.adapter = adapter

        vm.allRecipes?.observe(this, {
                recipeList -> getRecipe(recipeList)
        })

        vm = ViewModelProvider(this)[MainViewModel::class.java]

//        val linkFavList: View = findViewById(R.id.fav_view)
//        linkFavList.setOnClickListener{
//            val intent = Intent(this, FavoritesList::class.java)
//            startActivity(intent)
//        }
    }

    fun onCardClick(position: Int) {
        println("position:::$position")
        val myIntent = Intent(this, RecipePage::class.java)
        startActivity(myIntent)
    }

    fun getRecipe(recipeList: List<Recipe>) {
        this.recipeList.clear()
        this.recipeList.addAll(recipeList)
        adapter.notifyDataSetChanged()
    }
}