package com.example.recipegenie.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import com.example.recipegenie.R
import com.example.recipegenie.model.Recipe
import com.example.recipegenie.viewmodel.MainViewModel
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/NewRecipeForm.kt
import com.example.projectp0.R
=======
import com.example.recipegenie.R
import com.example.recipegenie.model.Recipe
import com.example.recipegenie.viewmodel.MainViewModel
>>>>>>> origin:app/src/main/java/com/example/recipegenie/view/NewRecipeForm.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class NewRecipeForm : AppCompatActivity() {

    lateinit var vm: MainViewModel

    private lateinit var title: EditText
    private lateinit var yields: EditText
    private lateinit var prepTime: EditText
    private lateinit var cookTime: EditText
    private lateinit var ingredients: EditText
    private lateinit var directions: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe_form)

        title = findViewById(R.id.edit_text_title)
        yields = findViewById(R.id.edit_text_yield)
        prepTime = findViewById(R.id.edit_text_prep_time)
        cookTime = findViewById(R.id.edit_text_cook_time)
        ingredients = findViewById(R.id.edit_text_ingredients)
        directions = findViewById(R.id.edit_text_directions)

        vm = MainViewModel(application)

<<<<<<< HEAD
        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_add)
=======
<<<<<<< HEAD
//        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_submit)
>>>>>>> main
//        val btnClear: ExtendedFloatingActionButton = findViewById(R.id.btn_clear)
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/NewRecipeForm.kt
        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_add)
       // val btnClear: ExtendedFloatingActionButton = findViewById(R.id.btn_clear)
=======
//        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_submit)
//        val btnClear: ExtendedFloatingActionButton = findViewById(R.id.btn_clear)
>>>>>>> origin:app/src/main/java/com/example/recipegenie/view/NewRecipeForm.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
        val btnCancel: ExtendedFloatingActionButton = findViewById(R.id.btn_cancel)


        btnSubmit.setOnClickListener {

            val title: String = title.text.toString()
            val yields: String = yields.text.toString()
            val prepTime: String = prepTime.text.toString()
            val cookTime: String = cookTime.text.toString()
            val ingredients: String = ingredients.text.toString()
            val directions: String = directions.text.toString()

            if (title.isNullOrBlank() || yields.isNullOrBlank() || prepTime.isNullOrBlank() ||
                cookTime.isNullOrBlank() || ingredients.isNullOrBlank() ||
                directions.isNullOrBlank()
            ) {
                if (title.isNullOrBlank())
                    this.title.setError("Please Enter a recipe title")
                if (yields.isNullOrBlank())
                    this.yields.setError("Please Enter number of servings")
                if (prepTime.isNullOrBlank())
                    this.prepTime.setError("Please Enter time it takes to prep ingredients")
                if (cookTime.isNullOrBlank())
                    this.cookTime.setError("Please Enter time it takes to cook")
                if (ingredients.isNullOrBlank())
                    this.ingredients.setError("Please the ingredient list")
                if (directions.isNullOrBlank())
                    this.directions.setError("Please Enter cooking steps")

                val builder = AlertDialog.Builder(this)
                // Set Alert Title
                builder.setTitle("All fields are required")
                // Set the message show for the Alert time
                builder.setMessage("Please complete the form")
                builder.setCancelable(true)
                builder.setNegativeButton("OK", DialogInterface.OnClickListener
                { dialog, which -> dialog.cancel() })

                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()

            } else {

                val recipe = Recipe(
                    null,
                    true,
                    title,
                    yields,
                    prepTime,
                    cookTime,
                    prepTime+cookTime, //TODO: need to calculate total time
                    ingredients,
                    directions,
                    ""
                )

                vm.insertRecipes(recipe)

                val intent = Intent(this, FavoritesList::class.java)
                intent.putExtra("title", recipe.title.toString())
                startActivity(intent)

                val message = "recipe successfully added"
                val duration = Toast.LENGTH_LONG
                val toast = Toast.makeText(applicationContext, message, duration)
                toast.show()
            }
        }

//        btnCancel.setOnClickListener {
//            val intent = Intent(this, FavoritesList::class.java)
//            startActivity(intent)
//
//            val message = "cancelled"
//            val duration = Toast.LENGTH_LONG
//            val toast = Toast.makeText(applicationContext, message, duration)
//            toast.show()
//        }

<<<<<<< HEAD
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/NewRecipeForm.kt
            val message = "cancelled"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()
        }

=======
>>>>>>> origin:app/src/main/java/com/example/recipegenie/view/NewRecipeForm.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
//        btnClear.setOnClickListener {
//            title.text.clear()
//            rYield.text.clear()
//            prepTime.text.clear()
//            totalTime.text.clear()
//            ingredients.text.clear()
//            directions.text.clear()
<<<<<<< HEAD
//        }
//    }
<<<<<<< HEAD
    }
}
=======
}
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/NewRecipeForm.kt
        }
    }
=======
//        }
//    }
}
>>>>>>> origin:app/src/main/java/com/example/recipegenie/view/NewRecipeForm.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0
>>>>>>> main
