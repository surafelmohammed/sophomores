package com.aait.zekaryastadele.sophomores.homeMenu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aait.zekaryastadele.sophomores.R


class RecommendationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_recommendation, container, false)

        // Inflate the layout for this fragment
        return view
    }


}
