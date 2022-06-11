package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber
import java.lang.RuntimeException

object StaticObject {
    var isDebugMode = true
}

class MainActivity : AppCompatActivity() {

    var crashlytics = Firebase.crashlytics

    var recipeList = ArrayList<Recipe>()
    lateinit var vm: MainViewModel
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


        vm.allRecipes?.observe(this) { recipeList ->
            try {
                getRecipe(recipeList)
            } catch (e: Exception) {
                crashlytics.log("Recipe List not received")
                crashlytics.recordException(e)
            }
        }


        val linkSearchList: View = findViewById(R.id.search_view)
        linkSearchList.setOnClickListener{
            val intent = Intent(this, search_recipes::class.java)
            startActivity(intent)
        }


        val linkFavList: View = findViewById(R.id.fav_view)
        linkFavList.setOnClickListener{
            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }

    }

    fun onCardClick(position: Int) {
        try{
            println("position:::$position")
            val myIntent = Intent(this, RecipePage::class.java)
            startActivity(myIntent)
        }
        catch (e: Exception){
            crashlytics.recordException(e)
        }
    }

    fun getRecipe(recipeList: List<Recipe>) {
        try{
            this.recipeList.clear()
            this.recipeList.addAll(recipeList)
            adapter.notifyDataSetChanged()
        }
        catch (e: Exception){
            crashlytics.recordException(e)
        }
    }
}