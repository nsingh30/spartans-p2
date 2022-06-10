package com.example.recipegenie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
<<<<<<< Updated upstream

class MainActivity : AppCompatActivity() {
=======
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    var databaseReference : DatabaseReference? =null
    var database : FirebaseDatabase? = null

    var recipeList = ArrayList<Recipe>()
    lateinit var vm : MainViewModel
    lateinit var adapter:RecipeAdapter

    lateinit var sign_out_btn : Button
    lateinit var username : TextView

>>>>>>> Stashed changes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream
        val linkFavList: View = findViewById(R.id.fav_view)
        linkFavList.setOnClickListener{
            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }
=======
        vm = MainViewModel(application)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView_category)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
            false)

        adapter = RecipeAdapter({position -> onCardClick(position)}, recipeList)
        recyclerView.adapter = adapter

        sign_out_btn = findViewById(R.id.sign_out_btn)
        username = findViewById(R.id.username)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        username.setText(auth.currentUser?.email)
        sign_out_btn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,LandingPage::class.java))
            finish()
        }
   //     loadProfile()

    }

    fun onCardClick(position: Int) {
        println("position:::$position")
        val myIntent = Intent(this, RecipePage::class.java)
        startActivity(myIntent)
    }

    fun getRecipe(recipeList: List<Recipe>) {
        this.recipeList.clear()
        this.recipeList.addAll(recipeList)
        adapter.notifyDataSetChanged()
>>>>>>> Stashed changes
    }

//    private fun loadProfile() {
//        val user = auth.currentUser
//        val userReference = databaseReference?.child(user?.uid!!)
//
//        userReference?.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                username.text = snapshot.child("username").value.toString()
////                email_id.text = snapshot.child("email_id").value.toString()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
////        sign_out_btn.setOnClickListener {
////            auth.signOut()
////            startActivity(Intent(this, LandingPage::class.java))
////            finish()
////        }
//
//
//    }


}