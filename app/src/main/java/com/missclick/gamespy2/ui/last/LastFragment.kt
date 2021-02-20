package com.missclick.gamespy2.ui.last

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.missclick.gamespy2.R

class LastFragment : Fragment() {

    companion object {
        fun newInstance(spy: Int):Bundle{
            return Bundle().apply {
                putInt("spy",spy)
            }
        }
    }

    private lateinit var viewModel: LastViewModel
    private var spy : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            spy = it.getInt("spy")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.last_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LastViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spyText = view.findViewById<TextView>(R.id.spy_text)
        spyText.text = "Игрок " + spy.toString() + " шпион!"
        val new = view.findViewById<Button>(R.id.new_button)
        new.setOnClickListener {
            viewModel.safe()
            findNavController().navigate(R.id.navigation_parameters)
        }
    }


}