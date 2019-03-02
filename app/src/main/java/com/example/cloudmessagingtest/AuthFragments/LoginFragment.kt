package com.example.cloudmessagingtest.AuthFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cloudmessagingtest.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initListener()
    }

    private fun initListener() {
        btnLoginSignIn.setOnClickListener {
            initLogin()
        }
        tvLoginToRegistration.setOnClickListener {
            replaceToRegistration()
        }
    }

    private fun initLogin() {
        //TO DO login function
    }

    private fun replaceToRegistration() {
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.auth_container, RegistrationFragment())
            .commit()
    }
}
