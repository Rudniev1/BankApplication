package com.example.bankapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bankapplication.libs.DecimalDigitsInputFilter


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

        val bankNumberInput = view.findViewById<EditText>(R.id.editText_BankNumber)
        bankNumberInput.filters = arrayOf(LengthFilter(26))

        val moneyInput = view.findViewById<EditText>(R.id.editText_Cash)
        moneyInput.filters = arrayOf<InputFilter>(
            DecimalDigitsInputFilter(
                5,
                2
            )
        )

        view.findViewById<Button>(R.id.button_back_from_transfer_layout).setOnClickListener {
            findNavController().navigate(R.id.action_transferActivity_to_homeActivity)
        }
            view.findViewById<Button>(R.id.button_transfer).setOnClickListener {
                val bankNumber = view.findViewById<EditText>(R.id.editText_BankNumber).text.toString()
                val cash = view.findViewById<EditText>(R.id.editText_Cash).text.toString()
                val receiver = view.findViewById<EditText>(R.id.editText_Receiver).text.toString()

                if(bankNumber != "" && (cash != "" || cash != "0") && receiver != "") {
                    val saldo = arguments?.getFloat("saldo")?.minus(cash.toFloat())
                    val bundle = bundleOf("saldoTransfer" to saldo)
                    findNavController().navigate(R.id.action_transferActivity_to_homeActivity,bundle)
                    Toast.makeText(context, "Przelew wykonany pomyślnie", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(context, "Brak danych do wykonania przelewu", Toast.LENGTH_SHORT).show()
                }
        }
    }
}