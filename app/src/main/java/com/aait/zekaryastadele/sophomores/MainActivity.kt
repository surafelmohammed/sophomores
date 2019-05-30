package com.aait.zekaryastadele.sophomores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var drawerLayout : DrawerLayout

    lateinit var toggle: ActionBarDrawerToggle

    lateinit var toolbar: androidx.appcompat.widget.Toolbar


    lateinit var navigationView : NavigationView


    lateinit var tabLayout : TabLayout

    lateinit var viewPager : ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)

        navigationView = findViewById(R.id.navigationView)

        drawerLayout = drawer

        //toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()


        viewPager = findViewById(R.id.view_pager)

        tabLayout = findViewById(R.id.tab_layout)




        setUpViewPager()








    }

    fun setUpViewPager(){
            val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
            viewPager.adapter = fragmentAdapter
            tabLayout.setupWithViewPager(viewPager)

    }


    class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    RecommendationFragment()
                }
                else -> {
                    return CatalogFragment()
                }
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "Recommendation"
                else -> {
                    return "Catalog"
                }
            }
        }
    }



}
