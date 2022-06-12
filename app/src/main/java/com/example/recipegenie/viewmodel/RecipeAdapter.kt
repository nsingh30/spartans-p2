package com.example.recipegenie.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.example.recipegenie.R
import com.example.recipegenie.model.Recipe
=======
<<<<<<< HEAD:app/src/main/java/com/example/recipegenie/RecipeAdapter.kt
import com.example.projectp0.R
=======
import com.example.recipegenie.R
import com.example.recipegenie.model.Recipe
>>>>>>> origin:app/src/main/java/com/example/recipegenie/viewmodel/RecipeAdapter.kt
>>>>>>> 747e91718e6bcebec2a63430b0f83a733afc7ce0

class RecipeAdapter (private val onCardClick: (position: Int) -> Unit,
                    private val recipeList: List<Recipe>)
                    : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate a view and return it
        var viewInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_card_layout, parent, false)

        return ViewHolder(viewInflater, onCardClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // add current item to the holder
        val recipe = recipeList[position]
        holder.idTextView.text = recipe.recipeId.toString()
        holder.titleTextView.text = recipe.title
        holder.yieldTextView.text = recipe.yields
        holder.prepTimeTextView.text = recipe.prepTime
        holder.totalTimeTextView.text = recipe.totalTime
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    class ViewHolder (view: View, private val onCardClick: (position: Int) -> Unit)
        : RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        var idTextView: TextView = view.findViewById(R.id.id)
        var titleTextView: TextView = view.findViewById(R.id.title)
        var yieldTextView: TextView = view.findViewById(R.id.r_yield)
        var prepTimeTextView: TextView = view.findViewById(R.id.prep_time)
        var totalTimeTextView: TextView = view.findViewById(R.id.total_time)

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            onCardClick(position)
        }
    }
}