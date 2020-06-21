package com.example.bankapplication

import android.os.Bundle
import android.text.InputFilter
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bankapplication.libs.*
import kotlin.math.round

class CreditActivity : Fragment() {

    var value: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_credit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moneyInput = view.findViewById<EditText>(R.id.editText_credit_value)
        moneyInput.filters = arrayOf<InputFilter>(
            DecimalDigitsInputFilter(
                5,
                1
            )
        )

        var installmentsTextView = view.findViewById<TextView>(R.id.label_credit_installments)
        val installmentsSeekBar = view.findViewById<SeekBar>(R.id.seekBar_credit_installments)

        installmentsSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, i: Int, p2: Boolean) {
                installmentsTextView.text = (6 + i).toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })


        view.findViewById<Button>(R.id.button_credit_calculate).setOnClickListener {
            val creditValue =
                view.findViewById<EditText>(R.id.editText_credit_value).text.toString().toInt()
            val installmentValue =
                view.findViewById<TextView>(R.id.label_credit_installments).text.toString()
                    .toInt()
            val textResult = view.findViewById<TextView>(R.id.textView_credit_output2)
            value = (creditValue * 1.02 * 1.05).round(2)
            val installmentValue2 = (value / installmentValue).round(2)
            val creditCost = (value - creditValue).round(2)

            textResult.text =
                "Koszt Kredytu to $creditCost zł\nCałkowity koszt kredytu to $value zł\nRata miesięczna to $installmentValue2 zł"

        }

        view.findViewById<Button>(R.id.button_back_from_credit_layout).setOnClickListener {
            findNavController().navigate(R.id.action_creditActivity_to_homeActivity)
        }

        view.findViewById<Button>(R.id.button_credit).setOnClickListener {
            val creditValue = view.findViewById<EditText>(R.id.editText_credit_value).text
            val currentCount = value
            if(currentCount > 0f) {
                val saldo = requireArguments().getFloat("credit") + creditValue.toString().toFloat()
                val bundle = bundleOf("saldoCredit" to saldo)
                findNavController().navigate(R.id.action_creditActivity_to_homeActivity,bundle)
                Toast.makeText(context,"Pożyczka przyznana",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}