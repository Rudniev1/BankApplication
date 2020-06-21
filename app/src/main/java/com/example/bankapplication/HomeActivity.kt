package com.example.bankapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeActivity : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
        view.findViewById<Button>(R.id.button_logout).setOnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_loginActivity)
        }

        view.findViewById<Button>(R.id.button_make_transfer).setOnClickListener {
            val valueSaldo = view.findViewById<TextView>(R.id.textView_saldo).text.toString().toFloat()
            val action = HomeActivityDirections.actionHomeActivityToTransferActivity()
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.button_credit).setOnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_creditActivity)
        }

        view.findViewById<Button>(R.id.button_blik).setOnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_blikActivity)
        }
    }
}