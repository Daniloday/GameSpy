package com.missclick.gamespy2.ui.cards

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gamespy2.dataClasses.Start
import com.missclick.gamespy2.R
import com.missclick.gamespy2.ui.time.TimeFragment

class CardsFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private var start : Start? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            start = it.getSerializable("start") as Start?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cardsViewModel =
                ViewModelProvider(this).get(CardsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cards, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
        cardsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val words = listOf("Кухня","Клуб","Автомобиль","Ресторан","Море")
        val word = words[(words.indices).random()]
        var player = 3
        if (start!!.players > 1)
            player = start!!.players
        var time = 120
        if (start!!.time > 0)
            time = start!!.time
        var playerNow = 1
        val spy = (1..player).random()
        val playerText = view.findViewById<TextView>(R.id.number_text)
        val nextBtn = view.findViewById<Button>(R.id.show_button)
        val wordText = view.findViewById<TextView>(R.id.word_text)


        nextBtn.text = "Показать"
        var show = true
        playerText.text = "Игрок " + playerNow
        nextBtn.setOnClickListener {
            cardsViewModel.safe()
            if (show){
                show = false
                nextBtn.text = "Следующий"
                if (playerNow != spy) wordText.text = word
                else wordText.text = "Шпион"

            }
            else{
                show = true
                nextBtn.text = "Показать"
                wordText.text = ""
                playerNow += 1
                if (playerNow > player)
                    findNavController().navigate(R.id.navigation_time,TimeFragment.newInstance(time = time,spy = spy))
                else
                    playerText.text = "Игрок " + playerNow
            }
        }


    }

    companion object {
        fun newInstance(start : Start):Bundle{
            return Bundle().apply {
                putSerializable("start", start)
            }
        }
    }
}