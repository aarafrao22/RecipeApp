package com.aarafrao.recipeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ProductFragment : Fragment() {
    private val recyclerView: RecyclerView
        get() = view?.findViewById(R.id.rv)!!

    private val editText: EditText
        get() = view?.findViewById(R.id.editText)!!

    private var list: MutableList<ProductModel>? = null
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

        //instance of list in which our data will be showing
        list = ArrayList()


        adapter = ProductAdapter(list!!)


        val layoutManager = GridLayoutManager(activity, 2)
        layoutManager.orientation = RecyclerView.VERTICAL

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        //getting list in the function
        listData()

        //refreshing list
        adapter!!.notifyDataSetChanged()


        //if any change on text box occurred this method will be called

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Toast.makeText(context, "Text Changed", Toast.LENGTH_SHORT).show()
            }
        })


    }

    //use this method if you want search functionality
    private fun filter(s: String) {

        val filteredlist: ArrayList<ProductModel> = ArrayList()
        for (item in list!!) {
            if (item.price.toLowerCase().contains(s.toLowerCase())) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(context, "Could'nt find Results", Toast.LENGTH_SHORT).show()
        } else {
            adapter?.filterList(filteredlist)
        }

    }

    private fun listData() {

        list?.add(ProductModel("Galaxy s20", "Gamong Phone", "$902"))
        list?.add(ProductModel("Iphone 14", "Camera Phone", "$24"))
        list?.add(ProductModel("Google pixel", "Smart", "$2"))
        list?.add(ProductModel("Oppo s1", "High Tech", "$4"))
    }

}