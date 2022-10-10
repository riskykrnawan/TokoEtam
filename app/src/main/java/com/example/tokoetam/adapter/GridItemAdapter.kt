package com.example.tokoetam.adapter

import android.content.Context
import android.content.Intent
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tokoetam.R
import com.example.tokoetam.activity.DetailItemActivity
import com.example.tokoetam.model.ItemModel

class GridItemAdapter(private val context: Context): RecyclerView.Adapter<GridItemAdapter.GridViewHolder>() {
    companion object {
        private lateinit var itemList: ArrayList<ItemModel>
    }

    fun setItemList(itemList: ArrayList<ItemModel>) {
        Companion.itemList = itemList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item: ItemModel = itemList[position]

        Glide.with(context)
            .load(item.img)
            .apply(RequestOptions.overrideOf(350, 650))
            .into(holder.img)

        holder.title.text = if (item.title.count() > 60) "${item.title.substring(0,60)} ...."
                else item.title

        val formatPrice = "%,d".format(item.price)
        holder.price.text = "Rp. $formatPrice"


        holder.itemTerjual.text = "${item.totalTerjual} terjual"


        val floatRating = item.rating.toFloat()
        holder.numberRating.text = floatRating.toString()
        holder.ratingBar.rating = floatRating

        holder.jumlahReviewer.text = "(${item.jumlahReviewer})"

        holder.itemCard.setOnClickListener{
            Toast.makeText(holder.itemView.context, "The " + itemList[position].title + " is selected", Toast.LENGTH_SHORT).show()
//            val intent = Intent(holder.itemView.context, DetailItemActivity::class.java)
//            intent.putExtra(DetailItemActivity.EXTRA_TITLE, itemList[position].title)
//            intent.putExtra(DetailItemActivity.EXTRA_IMG, itemList[position].img)
//            intent.putExtra(DetailItemActivity.EXTRA_DESCRIPTION, itemList[position].description)
//            intent.putExtra(DetailItemActivity.EXTRA_PRICE, itemList[position].price)
//            intent.putExtra(DetailItemActivity.EXTRA_TOTAL_TERJUAL, itemList[position].totalTerjual)
//            intent.putExtra(DetailItemActivity.EXTRA_RATING, itemList[position].rating)
//            intent.putExtra(DetailItemActivity.EXTRA_JUMLAH_REVIEWER, itemList[position].jumlahReviewer)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img: ImageView = super.itemView.findViewById(R.id.item_image)
        val title: TextView = super.itemView.findViewById(R.id.item_title)
        val price: TextView = super.itemView.findViewById(R.id.item_price)
        val itemCard: CardView = super.itemView.findViewById(R.id.item_card)
        val ratingBar: RatingBar = super.itemView.findViewById(R.id.rating)
        val numberRating: TextView = super.itemView.findViewById(R.id.number_rating)
        val itemTerjual: TextView = super.itemView.findViewById(R.id.item_terjual)
        val jumlahReviewer: TextView = super.itemView.findViewById(R.id.jumlah_reviewer)
    }


}