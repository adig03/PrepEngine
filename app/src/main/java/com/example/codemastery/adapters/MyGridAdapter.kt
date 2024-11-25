package com.example.codemastery.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.codemastery.Models.GridItem
import com.example.codemastery.Quizes.QuizActivity
import com.example.codemastery.R
import com.example.codemastery.WorkinProgressActivity

import org.w3c.dom.Text

class MyGridAdapter(context:Context , val GridItems: List<GridItem>): BaseAdapter() {
    val inflater:LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return GridItems.size
    }

    override fun getItem(p0: Int): Any {
        return GridItems[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView : View = p1 ?: inflater.inflate(R.layout.grid_wol_item ,p2 , false)

        val item = getItem(p0) as GridItem

        val gridText: TextView = itemView.findViewById<TextView>(R.id.grid_text)
        val gridImage: ImageView = itemView.findViewById<ImageView>(R.id.grid_image)

        gridText.text = item.gridtext
        gridImage.setImageResource(item.gridImage)


        itemView.setOnClickListener { view ->
            if (item.gridtext == "Quizzes") {
                val intent = Intent(view.context, QuizActivity::class.java)
                view.context.startActivity(intent)
            }
//            else if(item.gridtext == "e-Books"){
////
//                view.context.startActivity(intent)             val intent = Intent(view.context , EbookActivity::class.java)
//            }
            else{
                val intent = Intent(view.context , WorkinProgressActivity::class.java)
                view.context.startActivity(intent)
            }
        }

        return itemView

    }

}
