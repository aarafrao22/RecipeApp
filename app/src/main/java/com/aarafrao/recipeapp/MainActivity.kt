package com.aarafrao.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    var tablayout: TabLayout? = null
        get() = findViewById(R.id.tablayout);
    private var viewpager: ViewPager? = null
    var vpAdapter: VPAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating instance of adapter for view pager

        vpAdapter = VPAdapter(
            supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

        viewpager = findViewById(R.id.pager)
        tablayout?.setupWithViewPager(viewpager)

        //adding members of viewpager
        vpAdapter!!.addFragment(RecipeFragment(), "Recipe")
        vpAdapter!!.addFragment(ProductFragment(), "Product")
        viewpager?.setAdapter(vpAdapter)


    }
}