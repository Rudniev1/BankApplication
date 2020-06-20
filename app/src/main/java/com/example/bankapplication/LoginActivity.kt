package com.example.bankapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import android.content.res.Resources

class LoginActivity : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_login, container, false)
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_login).setOnClickListener {
            val login = view.findViewById<EditText>(R.id.editTextPersonName).text.toString()
            val pass = view.findViewById<EditText>(R.id.editTextPassword).text.toString()
            val passSet: String = getString(R.string.haslo)
            val loginSet: String = getString(R.string.login)
           if(passSet == pass && loginSet == login) {
                findNavController().navigate(R.id.action_loginActivity_to_homeActivity)
            }
            else {
                val loginFailed = Toast.makeText(context, "Nie udało się zalogować", Toast.LENGTH_SHORT)
                loginFailed.show()
            }
        }
    }

}