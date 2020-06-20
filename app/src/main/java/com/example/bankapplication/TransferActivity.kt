package com.example.bankapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class TransferActivity: Fragment(){

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.content_transfer, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bankNumber = view.findViewById<EditText>(R.id.editTextBankNumber).text.toString()
        val cash = view.findViewById<EditText>(R.id.editTextCash).text.toString()
        val receiver = view.findViewById<EditText>(R.id.editTextReceiver).text.toString()

        view.findViewById<Button>(R.id.button_back_from_transfer_layout).setOnClickListener {
            findNavController().navigate(R.id.action_transferActivity_to_homeActivity)
        }
            view.findViewById<Button>(R.id.button_transfer).setOnClickListener {

                if(bankNumber != "" || cash != "" || receiver != "") {
                    findNavController().navigate(R.id.action_transferActivity_to_homeActivity)
                    Toast.makeText(context, "Przelew wykonany pomyślnie", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(context, "Brak danych do wykonania przelewu", Toast.LENGTH_SHORT).show()
                }
        }
    }
}