package com.aarafrao.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext


class ProductAdapter(
    private var speedLimitModels: List<ProductModel>
) :
    RecyclerView.Adapter<ProductAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        //setting data on our View
        holder.setData(
            speedLimitModels[position].title,
            speedLimitModels[position].desc,
            speedLimitModels[position].price
        )
    }

    override fun getItemCount(): Int {
        return 4
    }

    fun filterList(filteredlist: ArrayList<ProductModel>) {
        speedLimitModels = filteredlist
        notifyDataSetChanged()

    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtDate: TextView
        private val txtLocation: TextView
        private val txtHours: TextView

        //setting ids of item or Views

        init {
            txtDate = itemView.findViewById(R.id.hs_product_title)
            txtLocation = itemView.findViewById(R.id.hs_product_description)
            txtHours = itemView.findViewById(R.id.hs_product_price)
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, txtDate.text.toString(), Toast.LENGTH_SHORT).show()
            }

        }

        //it will set data on item from our given list
        fun setData(date: String, location: String, speed: String) {
            txtDate.text = date
            txtLocation.text = location
            txtHours.text = speed


        }


    }
}