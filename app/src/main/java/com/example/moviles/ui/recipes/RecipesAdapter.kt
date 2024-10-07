package com.example.moviles.ui.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.moviles.R

class RecipesAdapter(private val recipes: List<Recipe>) : BaseAdapter() {
    override fun getCount(): Int = recipes.size

    override fun getItem(position: Int): Any = recipes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val recipe = getItem(position) as Recipe
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.recipe_item, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.recipeImage)
        val textView = view.findViewById<TextView>(R.id.recipeName)

        imageView.setImageResource(recipe.imageResId)
        textView.text = recipe.name

        return view
    }
}
