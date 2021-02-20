package com.missclick.gamespy2.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gamespy2.R

class StartFragment : Fragment() {

    private lateinit var startViewModel: StartViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        startViewModel =
                ViewModelProvider(this).get(StartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_start, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
        startViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val start = view.findViewById<Button>(R.id.start_button)
        start.setOnClickListener {
            startViewModel.safe()
            findNavController().navigate(R.id.navigation_parameters)
        }
    }
}