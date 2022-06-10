package com.example.recipegenie

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent as Intent1


class LandingPage : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var sign_in_btn :Button
    lateinit var sign_up :TextView
    lateinit var guest :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        auth = FirebaseAuth.getInstance()

        sign_in_btn = findViewById(R.id.sign_in_btn)
        sign_up = findViewById(R.id.sign_up)
        guest = findViewById(R.id.guest)

        val currentuser = auth.currentUser
        if (currentuser != null){
            startActivity(android.content.Intent(this, MainActivity::class.java))
            finish()
        }


        sign_up.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent1(this@LandingPage, RegistrationActivity::class.java))
            }
        })
        guest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent1(this@LandingPage, SearchRecipes::class.java))
            }
        })
        sign_in_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent1(this@LandingPage, LoginActivity::class.java))
            }
        })


    }
}


/*
* 1. Changed the name of LandingPage Activity and also in the manifest
* 2. Changed manifest activity MainActivity to LoadingPage Activity as launcher
* 3. changed SearchRecipes in manifest for naming std
* 4. where to keep sign_out btn
*
* */






