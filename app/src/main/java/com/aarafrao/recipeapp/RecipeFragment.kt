package com.aarafrao.recipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.aarafrao.recipeapp.ExpandableListData.data


class RecipeFragment : Fragment() {

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableListView = view.findViewById(R.id.expendableList)
        if (expandableListView != null) {


            //getting data here from Another class
            val listData = data


            titleList = ArrayList(listData.keys)

            adapter = CustomExpandableListAdapter(
                requireContext().applicationContext,
                titleList as ArrayList<String>,
                listData
            )


            //if list expand

            expandableListView!!.setAdapter(adapter)
            expandableListView!!.setOnGroupExpandListener { groupPosition ->
                Toast.makeText(
                    context,
                    (titleList as ArrayList<String>)[groupPosition] + " List Expanded.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //if list collapse
            expandableListView!!.setOnGroupCollapseListener { groupPosition ->
                Toast.makeText(
                    context,
                    (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //if user click on child
            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
                Toast.makeText(
                    context,
                    "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(
                            titleList as
                                    ArrayList<String>
                            )
                            [groupPosition]]!!.get(
                        childPosition
                    ),
                    Toast.LENGTH_SHORT
                ).show()
                false
            }

        }

    }
}