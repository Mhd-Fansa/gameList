package com.raywenderlich.android.alltherecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class GameAdapter(private val context: Context,
                  private val dataSource: ArrayList<Game>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_game, parent, false)

        // Get title element
        val nameTextView = rowView.findViewById(R.id.game_list_name) as TextView

// Get subtitle element
        val priceTextView = rowView.findViewById(R.id.game_list_price) as TextView

// Get detail element
        val discountTextView = rowView.findViewById(R.id.game_list_discount) as TextView

// Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.game_list_thumbnail) as ImageView

        // 1
        val game = getItem(position) as Game

// 2
        nameTextView.text = game.name
        priceTextView.text = game.price
        discountTextView.text = game.discountPrice

// 3
        Picasso.with(context).load(game.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)


        return rowView
    }
}