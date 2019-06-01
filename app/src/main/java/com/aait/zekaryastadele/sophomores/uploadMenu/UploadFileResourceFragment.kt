package com.aait.zekaryastadele.sophomores.uploadMenu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner

import com.aait.zekaryastadele.sophomores.R


class UploadFileResourceFragment : Fragment() {

    lateinit var list_of_items : Array<String>
    lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_upload_file_resource, container, false)

        list_of_items = arrayOf("Assignment", "Lecture","Exam")
        spinner = view.findViewById(R.id.spinner)

        setUpSpinner()

        return view
    }


    fun setUpSpinner(){
        val array_adapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,list_of_items)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = array_adapter
    }


}
