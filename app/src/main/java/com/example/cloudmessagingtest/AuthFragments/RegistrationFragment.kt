package com.example.cloudmessagingtest.AuthFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cloudmessagingtest.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInitialData()
        initListener()
    }

    private fun initListener() {
        btnRegisterNewUser.setOnClickListener {
            initRegistration()
        }
        tvLoginToRegistration.setOnClickListener {
            replaceToLoginFragment()
        }
    }

    private fun initRegistration() {
        //TO DO make registration function
    }

    private fun replaceToLoginFragment() {
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.auth_container, LoginFragment())
            .commit()
    }

    private fun setInitialData() {
        setTitle()
    }

    private fun setTitle() {
        activity!!.title = getString(R.string.Registration)
    }
}
