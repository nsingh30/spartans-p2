package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoritesList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_list)

        val btnAdd : FloatingActionButton = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener(){
            val intent = Intent(this, NewRecipeForm:: class.java)
            startActivity(intent)
        }

        val linkFavList: View = findViewById(R.id.card_view_recipe)
        linkFavList.setOnClickListener{
            val intent = Intent(this, RecipePage::class.java)
            startActivity(intent)
        }

    }
}