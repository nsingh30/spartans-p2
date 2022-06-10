package com.example.recipegenie

import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.recipegenie.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var sign_in_btn : Button
    lateinit var cancel_btn : Button
    lateinit var reset_pwd : TextView
    lateinit var vm : UsersViewModel
    lateinit var username : TextInputEditText
    lateinit var password : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        vm = UsersViewModel(application)
        sign_in_btn = findViewById(R.id.sign_in_btn)
        cancel_btn = findViewById(R.id.cancel_btn)
        reset_pwd = findViewById(R.id.reset_pwd)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if (currentuser != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
//        reset_pwd.setOnClickListener {
//            auth.sendPasswordResetEmail(username.text.toString())
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.d(ContentValues.TAG, "Email sent.")
//                    }
//                }
//
//        }
            reset_pwd.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if (username.text.toString().isNotEmpty()) {

                        auth.sendPasswordResetEmail(username.text.toString())
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val builder = AlertDialog.Builder(this@LoginActivity)
                                    builder.setMessage("Email Sent to ${username.text.toString()}")
                                    builder.setCancelable(true)
                                    builder.setNegativeButton("OK", DialogInterface.OnClickListener
                                    { dialog, which -> dialog.cancel() })
                                    val alertDialog: AlertDialog = builder.create()
                                    alertDialog.show()

                                    Log.d(ContentValues.TAG, "Email sent.")
                                }
                                startActivity(Intent(this@LoginActivity, LandingPage::class.java))

                            }
                    } else {
                        val builder = AlertDialog.Builder(this@LoginActivity)
                        builder.setMessage("Please enter your email id")
                        builder.setCancelable(true)
                        builder.setNegativeButton("OK", DialogInterface.OnClickListener
                        { dialog, which -> dialog.cancel() })
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()

                    }
                }
                })

        login()
    }


    private fun login() {

        sign_in_btn.setOnClickListener {
           if((username.text.toString()).isEmpty()){
               username.setHint("Plaese Enter your Email id")
               username.setHintTextColor(Color.RED)
           } else if((password.text.toString()).isEmpty()){
               password.setHint("Plaese Enter your password")
               password.setHintTextColor(Color.RED)
        }

            val vFieldValidationError: String = fieldValidationError()
            if (vFieldValidationError != "No Error") {
                val builder = AlertDialog.Builder(this@LoginActivity)
                builder.setMessage("Please enter Required fields")
                builder.setCancelable(true)
                builder.setNegativeButton("OK", DialogInterface.OnClickListener
                { dialog, which -> dialog.cancel() })
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
                return@setOnClickListener
            }
        auth.signInWithEmailAndPassword(username.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
//                        startActivity(Intent(this, FavoritesList::class.java))

                        finish()
                    } else {
                        val builder = AlertDialog.Builder(this@LoginActivity)
                        builder.setMessage("Please enter valid email id and password")
                        builder.setCancelable(true)
                        builder.setNegativeButton("OK", DialogInterface.OnClickListener
                        { dialog, which -> dialog.cancel() })
                        val alertDialog: AlertDialog = builder.create()
                        alertDialog.show()
                        Toast.makeText(this, "Login failed, please try again!", Toast.LENGTH_SHORT)
                    }
                }

            }
        cancel_btn.setOnClickListener {
            startActivity(Intent(this, LandingPage::class.java))
        }


    }

    private fun fieldValidationError(): String {
        when (true) {
             (username.text.toString()).isEmpty() -> {
                return  "Plaese Enter your Email id"

            } (password.text.toString()).isEmpty() -> {
                return   "Plaese Enter Password"

            }(android.util.Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()) ->{
                return "Plaese Enter valid Email id"

            }            else -> {
                return "No Error"
            }
        }
    }


}