package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
<<<<<<< HEAD
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/UdateRecipte.kt
import com.example.projectp0.R
=======
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
import com.example.recipegenie.model.Recipe
import com.example.recipegenie.model.RecipeRepository
import com.example.recipegenie.view.FavoritesList
import com.example.recipegenie.viewmodel.MainViewModel
<<<<<<< HEAD
=======
>>>>>>> origin:app/src/main/java/com/example/recipegenie/view/UpdateRecipte.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class UpdateRecipe : AppCompatActivity() {
    lateinit var vm: MainViewModel

    private lateinit var id: TextView
    private lateinit var title: TextInputEditText
    private lateinit var rYield: TextInputEditText
    private lateinit var prepTime: TextInputEditText
    private lateinit var totalTime: TextInputEditText
    private lateinit var ingredients: TextInputEditText
    private lateinit var directions: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_recipe)

        vm = MainViewModel(application)

        // unwrap Intent
        getData()

        val btnUpdate: ExtendedFloatingActionButton = findViewById(R.id.btn_update)
        val btnCancel: ExtendedFloatingActionButton = findViewById(R.id.btn_cancel)

        btnCancel.setOnClickListener {
            val message = "cancelled"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()

            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }


        btnUpdate.setOnClickListener {
            var recipe = Recipe(
                id.text.toString().toInt(), title.text.toString(),
                rYield.text.toString(), prepTime.text.toString(), totalTime.text.toString(),
                ingredients.text.toString(), directions.text.toString()
            )
            vm.updateRecipe(recipe)

            val message = "recipe updated"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()

            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        val repo: RecipeRepository by lazy {
            RecipeRepository(this)
        }
        // Map TextViews in recipe page
//        id = findViewById(R.id.text_view_id)
        title = findViewById(R.id.edit_text_title)
        rYield = findViewById(R.id.edit_text_yield)
        prepTime = findViewById(R.id.edit_text_prep_time)
        totalTime = findViewById(R.id.edit_text_total_time)
        ingredients = findViewById(R.id.edit_text_ingredients)
        directions = findViewById(R.id.edit_text_directions)

        // Get recipe from repo with title
        val recipe: List<Recipe> =
            repo.findRecipeWithTitle(intent.getStringExtra("title").toString())

        // Populate Text Views with recipe fields
        id.text = recipe[0].recipeId.toString()
        title.setText(recipe[0].title)
        rYield.setText(recipe[0].rYield)
        prepTime.setText(recipe[0].prepTime)
        totalTime.setText(recipe[0].totalTime)
        ingredients.setText(recipe[0].ingredients)
        directions.setText(recipe[0].directions)
    }
}