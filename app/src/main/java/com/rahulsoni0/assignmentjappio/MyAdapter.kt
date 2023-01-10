package com.rahulsoni0.assignmentjappio

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rahulsoni0.assignmentjappio.model.DataModel


class MyAdapter(private val mList: List<DataModel>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // create new views
    var row_index: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class

        holder.image.setImageResource(ItemsViewModel.imageUrl)

        // sets the text to the textview from our itemHolder class
        holder.name.text = ItemsViewModel.name
        holder.date.text = ItemsViewModel.date
        holder.price.text = ItemsViewModel.price
        holder.itemView.setOnClickListener(View.OnClickListener {
            row_index = position
            notifyDataSetChanged()
        })
        if (row_index === position) {
            holder.card.setCardBackgroundColor(Color.parseColor("#00E5FF"))

        } else {
            holder.card.setCardBackgroundColor(Color.WHITE)

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val card: CardView = itemView.findViewById(R.id.itemCard)
        val image: ImageView = itemView.findViewById(R.id.icon)
        val name: TextView = itemView.findViewById(R.id.itemName)
        val date: TextView = itemView.findViewById(R.id.itemDate)
        val price: TextView = itemView.findViewById(R.id.itemPrice)
    }

}