package com.aait.zekaryastadele.sophomores.homeMenu


import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aait.zekaryastadele.sophomores.R
import com.google.android.material.tabs.TabLayout


class MainContentFragment : Fragment() {




    lateinit var tabLayout : TabLayout

    lateinit var viewPager : ViewPager






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_maincontent, container, false)


        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)


        view.findViewById<ImageView>(R.id.drawerOnSearch).setOnClickListener {
            activity?.findViewById<DrawerLayout>(R.id.drawer)?.openDrawer(GravityCompat.START)
        }



        setUpViewPager()



        return view
    }


    fun setUpViewPager(){
        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
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
            return when(position){
                0-> "Search"
                else-> "Catalog"
            }
        }
    }





}


