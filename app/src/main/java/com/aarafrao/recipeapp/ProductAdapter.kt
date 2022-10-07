package com.aarafrao.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(private var speedLimitModels: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setData(
            speedLimitModels[position].day, speedLimitModels[position].location,
            speedLimitModels[position].speed
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

        init {
            txtDate = itemView.findViewById(R.id.hs_product_title)
            txtLocation = itemView.findViewById(R.id.hs_product_description)
            txtHours = itemView.findViewById(R.id.hs_product_price)
        }

        fun setData(date: String, location: String, speed: String) {
            txtDate.text = date
            txtLocation.text = location
            txtHours.text = speed
        }
    }
}