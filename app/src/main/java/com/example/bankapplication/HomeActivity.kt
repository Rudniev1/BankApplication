package com.example.bankapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
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

        var textSaldo = view.findViewById<TextView>(R.id.textView_saldo)
        var saldoFinal: Float = 0f
        val saldoTransfer = requireArguments().getFloat("saldoTransfer")

        if(saldoTransfer != 0f) {
            println("saldoFinal:  $saldoFinal")
            println("saldo Transfer: $saldoTransfer")
                saldoFinal =  saldoTransfer
           textSaldo.text = saldoFinal.toString()
        }
        else
        {
            view.findViewById<TextView>(R.id.textView_saldo).text = getString(R.string.value_saldo)
        }

        view.findViewById<Button>(R.id.button_logout).setOnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_loginActivity)
        }

        view.findViewById<Button>(R.id.button_make_transfer).setOnClickListener {
            val valueSaldo = textSaldo.text.toString().toFloat()
            val bundle = bundleOf("saldo" to saldoFinal)
            findNavController().navigate(R.id.action_homeActivity_to_transferActivity,bundle)
        }

        view.findViewById<Button>(R.id.button_credit).setOnClickListener {
            val valueSaldo = textSaldo.text.toString().toFloat()
            val bundle = bundleOf("credit" to saldoFinal)
            findNavController().navigate(R.id.action_homeActivity_to_creditActivity)
        }

        view.findViewById<Button>(R.id.button_blik).setOnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_blikActivity)
        }
    }
}