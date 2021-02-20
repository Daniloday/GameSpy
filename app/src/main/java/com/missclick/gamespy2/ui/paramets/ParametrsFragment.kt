package com.missclick.gamespy2.ui.paramets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gamespy2.dataClasses.Start
import com.missclick.gamespy2.R
import com.missclick.gamespy2.ui.cards.CardsFragment

class ParametrsFragment : Fragment() {

    private lateinit var parametrsViewModel: ParametrsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        parametrsViewModel =
                ViewModelProvider(this).get(ParametrsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_parameters, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        parametrsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val start = view.findViewById<Button>(R.id.next_button)
        val players = view.findViewById<EditText>(R.id.players_edit_text)
        val time = view.findViewById<EditText>(R.id.time_edit_text)
        start.setOnClickListener {
            parametrsViewModel.safe()
            var pl = 3
            var tm = 120
            if (players.text.toString() != "")
                pl = players.text.toString().toInt()
            if (time.text.toString() != "")
                tm = time.text.toString().toInt()
            findNavController().navigate(R.id.navigation_cards,CardsFragment.newInstance(start = Start(players = pl,time = tm)))
        }
    }
}