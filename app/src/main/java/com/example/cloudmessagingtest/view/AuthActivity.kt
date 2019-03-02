package com.example.cloudmessagingtest.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cloudmessagingtest.R
import com.example.cloudmessagingtest.view.AuthFragments.LoginFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setInitialData()
    }

    private fun setInitialData() {
        setInitFragment()
    }

    private fun setInitFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.auth_container,
                LoginFragment()
            )
            .commit()
    }
}
