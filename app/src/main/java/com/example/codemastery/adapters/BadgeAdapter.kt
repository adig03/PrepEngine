package com.example.codemastery.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import com.example.codemastery.Models.Badge
import com.example.codemastery.R

class BadgeAdapter(private val context: Context, private val badges: List<Badge>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return badges.size
    }

    override fun getItem(position: Int): Any {
        return badges[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View = convertView ?: inflater.inflate(R.layout.badegs_gridview, parent, false)

        val badge = badges[position]

        val badgeImageView = itemView.findViewById<ImageView>(R.id.badgeImage)


        badgeImageView.setImageResource(badge.image)

        // Handle touch events to show the popup with the description
        badgeImageView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Show popup window with the description
                    showBadgeDescriptionPopup(badge, itemView)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Hide the popup window when touch ends
                    hideBadgeDescriptionPopup()
                }
            }
            true
        }

        return itemView
    }

    // PopupWindow to display badge description
    private var popupWindow: PopupWindow? = null


    @SuppressLint("MissingInflatedId")
    private fun showBadgeDescriptionPopup(badge: Badge, anchorView: View) {

        val popupView = inflater.inflate(R.layout.popup_badge_description, null)

        val descriptionTextView = popupView.findViewById<TextView>(R.id.badgeDescriptionTextView)
        descriptionTextView.text = badge.description
        val nameTextView = popupView.findViewById<TextView>(R.id.nameOfTheBadge)
        nameTextView.setText(badge.name)
        val LevelTextView = popupView.findViewById<TextView>(R.id.levelOfTheBadge)
        LevelTextView.setText(badge.level)


        popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)


        popupWindow?.showAsDropDown(anchorView, 0, -anchorView.height)
    }

    // Function to hide the popup window
    private fun hideBadgeDescriptionPopup() {
        popupWindow?.dismiss()
    }
}
