package com.aait.zekaryastadele.sophomores.uploadMenu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aait.zekaryastadele.sophomores.R
import com.aait.zekaryastadele.sophomores.homeMenu.CatalogFragment
import com.aait.zekaryastadele.sophomores.homeMenu.MainContentFragment
import com.aait.zekaryastadele.sophomores.homeMenu.RecommendationFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_upload.view.*


class UploadFragment : Fragment() {

    lateinit var tabs : TabLayout

    lateinit var viewPager : ViewPager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_upload, container, false)


        tabs = view.tabs
        viewPager = view.viewpager



        setUpViewPager()





        // Inflate the layout for this fragment
        return view
    }

    fun setUpViewPager(){
        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

    }


}

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                UploadFileResourceFragment()
            }
            else -> {
                return UploadTextFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "File resource"
            else -> "Text resource"
        }

    }


}
