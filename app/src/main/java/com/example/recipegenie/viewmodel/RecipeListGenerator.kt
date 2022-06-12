package com.example.recipegenie.viewmodel
/*
This class generates an ArrayList<Recipe> from LiveData<List<Recipe>>
 or from MutableLiveData<RecipeResults.
 */
import android.text.TextUtils.lastIndexOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import com.example.recipegenie.R
import com.example.recipegenie.RecipeResults
import com.example.recipegenie.model.Recipe

class RecipeListGenerator {

    private var recipeList = ArrayList<Recipe>()

    fun makeList(owner: LifecycleOwner, liveData: LiveData<List<Recipe>>?) : ArrayList<Recipe> {
        liveData?.observe(owner) { recipeList  ->
            this.recipeList.clear()
            this.recipeList.addAll(recipeList)
        }
        return  recipeList
    }

    fun makeList(owner: LifecycleOwner, mutableLiveData: MutableLiveData<RecipeResults>)
    : ArrayList<Recipe> {
        mutableLiveData.observe(owner){
            this.recipeList.clear()

            // create a recipe from search results
            if(!it.results.isNullOrEmpty()) {
                var recipe = Recipe(null, false,"","","",
                    "", "", "", "","")
                for (index in 0..it.results.lastIndex) {
                    // ingredients array to String
                    var ingredients = ""
                    for(i in 0..it.results[index].sections[0].components.lastIndex){
                        ingredients += it.results[index].sections[0].components[i].raw_text + "\n"}

                    // instructions[] to String
                    var directions = ""
                    for(i in 0..it.results[index].instructions.lastIndex){
                        directions += it.results[index].instructions[i].display_text + "\n"}

                    var id : Int = it.results[index].id
                    var isFavorite = false
                    var name : String =  it.results[index].name // AKA title
                    var yields: String = it.results[index].yields
                    var prepTime: String = "${it.results[index].prep_time_minutes} minutes"
                    var coockTime: String = "${it.results[index].cook_time_minutes} minutes"
                    var totalTime: String = "${it.results[index].total_time_minutes} minutes"
                    var imageUrl: String = it.results[index].thumbnail_url

                    recipe.recipeId = id
                    recipe.isFavorite = isFavorite
                    recipe.title =name
                    recipe.yields = yields
                    recipe.prepTime = prepTime
                    recipe.cookTime = coockTime
                    recipe.totalTime = totalTime
                    recipe.ingredients = ingredients
                    recipe.directions = directions
                    recipe.imageUrl = imageUrl
                }
                recipeList.add(recipe)
            }
        }
        return recipeList
    }
}