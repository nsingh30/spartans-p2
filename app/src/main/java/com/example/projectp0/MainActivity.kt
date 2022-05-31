package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkFavList: View = findViewById(R.id.fav_view)
        linkFavList.setOnClickListener{
            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }
    }

//    private fun onCardClick(position: Int) {
//        println("Position:::$position")
//        val myIntent = Intent(this, StudentDetail::class.java)
//        myIntent.putExtra("Id", studentList[position].studentId)
//        myIntent.putExtra("Fname", studentList[position].firstName)
//        myIntent.putExtra("Lname", studentList[position].lastName)
//        startActivity(myIntent)
//    }
//
}