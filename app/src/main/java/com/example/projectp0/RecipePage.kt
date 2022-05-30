package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class RecipePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val btnHome : ExtendedFloatingActionButton = findViewById(R.id.btn_home)
        btnHome.setOnClickListener{
            val intent : Intent =  Intent (this, MainActivity:: class.java)
            startActivity(intent)
        }
    }
}