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

    private lateinit var title : EditText
    private lateinit var rYield : EditText
    private lateinit var prepTime : EditText
    private lateinit var totalTime : EditText
    private lateinit var ingredients : EditText
    private lateinit var directions : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe_form)

        val title : EditText = findViewById(R.id.edit_text_title)
        val rYield : EditText = findViewById(R.id.edit_text_yield)
        val prepTime : EditText = findViewById(R.id.edit_text_prep_time)
        val totalTime : EditText = findViewById(R.id.edit_text_total_time)
        val ingredients : EditText = findViewById(R.id.edit_text_ingredients)
        val directions : EditText = findViewById(R.id.edit_text_directions)

        vm = MainViewModel(application)

        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_submit)
        val btnClear: ExtendedFloatingActionButton = findViewById(R.id.btn_clear)
        val btnCancel: ExtendedFloatingActionButton = findViewById(R.id.btn_cancel)

        btnSubmit.setOnClickListener{
            val intent = Intent(this,RecipePage::class.java)

            val recipe = Recipe(null, title.text.toString(), rYield.text.toString(),
                prepTime.text.toString(), totalTime.text.toString(), ingredients.text.toString(),
                directions.text.toString())

            vm.insertRecipes(recipe)

            intent.putExtra("title", recipe.title.toString())
            startActivity(intent)
        }

        btnClear.setOnClickListener{
            title.text.clear()
            rYield.text.clear()
            prepTime.text.clear()
            totalTime.text.clear()
            ingredients.text.clear()
            directions.text.clear()
        }

        btnCancel.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}