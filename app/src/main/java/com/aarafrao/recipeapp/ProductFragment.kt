package com.aarafrao.recipeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ProductFragment : Fragment() {
    private val recyclerView: RecyclerView
        get() = view?.findViewById(R.id.rv)!!

    private var list: MutableList<SpeedLimitModel>? = null
    var adapter: ProductAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_product, container, false)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList()


        adapter = ProductAdapter(list!!)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        listData()
        adapter!!.notifyDataSetChanged()
    }

    private fun listData() {

        list?.add(SpeedLimitModel("56 August", "Nahi Clifton nh", "2"))
        list?.add(SpeedLimitModel("24 Sep", "Clifton", "24"))
        list?.add(SpeedLimitModel("24 Sep", "Nahi Clifton nh", "2"))
        list?.add(SpeedLimitModel("24 Sep", "Clifton", "24"))
        list?.add(SpeedLimitModel("24 Sep", "Clifton", "24"))

    }

}