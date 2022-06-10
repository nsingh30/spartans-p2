package com.example.recipegenie

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class RecipePage : AppCompatActivity() {
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val repo: RecipeRepository by lazy {
            RecipeRepository(this)
        }
        vm = MainViewModel(application)

        //populate TextFields with recipe data from repo and get recipeID as a String
        var recipe: Recipe = getData(repo)

        val btnEdit: ExtendedFloatingActionButton = findViewById(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val intent: Intent = Intent(this, UpdateRecipe::class.java)
            intent.putExtra("title", recipe.title)
            startActivity(intent)
        }


        val btnDelete: ExtendedFloatingActionButton = findViewById(R.id.btn_delete)
        btnDelete.setOnClickListener {
//          setOnClickListener  val builder = AlertDialog.Builder(this)
//            // Set Alert Title
//            builder.setTitle("Are you sure you want to delete recipe?")
//            // Set the message show for the Alert time
//            builder.setMessage("Hitting OK will delete the recipe")
//            builder.setCancelable(true)
//            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener()
//            { dialog, which -> dialog.cancel() })

//            builder.setPositiveButton(
//                "OK",DialogInterface.OnClickListener() {
//
//             )).show()
//

            vm.deleteRecipe(recipe)

            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)

            val message = "recipe deleted"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()
        }
    }

    private fun getData(repo: RecipeRepository): Recipe {
        // Map TextViews in recipe page
        var id: TextView = findViewById(R.id.id)
        var title: TextView = findViewById(R.id.title)
        var rYield: TextView = findViewById(R.id.r_yield)
        var prepTime: TextView = findViewById(R.id.prep_time)
        var totalTime: TextView = findViewById(R.id.total_time)
        var ingredients: TextView = findViewById(R.id.ingredients)
        var directions: TextView = findViewById(R.id.directions)

        // Get recipe from repo with ID
        var recipe: List<Recipe> =
            repo.findRecipeWithTitle(intent.getStringExtra("title").toString())

        // Populate Text Views with recipe fields
        id.text = recipe[0].recipeId.toString()
        title.text = recipe[0].title
        rYield.text = recipe[0].rYield
        prepTime.text = recipe[0].prepTime
        totalTime.text = recipe[0].totalTime
        ingredients.text = recipe[0].ingredients
        directions.text = recipe[0].directions

        return Recipe(
            id.text.toString().toInt(), title.text.toString(), rYield.text.toString(),
            prepTime.text.toString(), totalTime.text.toString(), ingredients.text.toString(),
            directions.text.toString()
        )
    }
}