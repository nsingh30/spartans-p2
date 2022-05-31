package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class NewRecipeForm : AppCompatActivity() {

    lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe_form)

        vm = MainViewModel(application)

        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener{
            val intent = Intent(this,RecipePage::class.java)

            var recipe : Recipe = makeRecipe()
            vm.insertRecipes(recipe)

            intent.putExtra("title", recipe.title)
            startActivity(intent)
        }
    }

    private fun makeRecipe() : Recipe {
        val title : String = editTextToString(findViewById(R.id.edit_text_title))
        val rYield : String = editTextToString(findViewById(R.id.edit_text_yield))
        val prepTime : String = editTextToString(findViewById(R.id.edit_text_prep_time))
        val totalTime : String = editTextToString(findViewById(R.id.edit_text_total_time))
        val ingredients : String = editTextToString(findViewById(R.id.edit_text_ingredients))
        val directions : String = editTextToString(findViewById(R.id.edit_text_directions))

        return Recipe(null, title, rYield, prepTime, totalTime, ingredients, directions)
    }

    private fun editTextToString(item:EditText): String{
        return item.text.toString()
    }
}