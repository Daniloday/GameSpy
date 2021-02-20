package com.missclick.gamespy2.ui.time

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gamespy2.R
import com.missclick.gamespy2.ui.last.LastFragment
import java.util.*

class TimeFragment : Fragment() {



    private lateinit var viewModel: TimeViewModel
    private var time : Int? = null
    private var spy : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            time = it.getInt("time")
            spy = it.getInt("spy")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.time_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TimeViewModel::class.java)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val timeText = view.findViewById<TextView>(R.id.time_text)
        val stop = view.findViewById<Button>(R.id.new_button)

        timeText.text = time.toString()
        Log.e("time", time.toString())
        time = time?.minus(1)
        fun start1(){
            Handler().postDelayed(
                    {
                        timeText.text = time.toString()
                        Log.e("time", time.toString())
                        time = time?.minus(1)
                        if (time!! > 0) start1()
                        else findNavController().navigate(R.id.navigation_last,LastFragment.newInstance(spy = spy!!))
                    },
                    1000 // value in milliseconds
            )
        }
        start1()
        stop.setOnClickListener {
            viewModel.safe()
            time = 0
            findNavController().navigate(R.id.navigation_last,LastFragment.newInstance(spy = spy!!))
        }
    }



    companion object {
        fun newInstance(time: Int,spy: Int):Bundle{
            return Bundle().apply {
                putInt("time", time)
                putInt("spy",spy)
            }
        }
    }
}