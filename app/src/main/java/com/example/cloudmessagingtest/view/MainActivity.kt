package com.example.cloudmessagingtest.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.cloudmessagingtest.R
import com.example.cloudmessagingtest.view.AuthFragments.MainFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    companion object {
        var currentUser: FirebaseUser? = null
    }

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInitialData()
    }

    private fun setInitialData() {
        mAuth = FirebaseAuth.getInstance()
        fetchCurrentUser()
        setMainFragment()
    }

    private fun setMainFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, MainFragment())
            .commit()
    }

    private fun fetchCurrentUser() {
        currentUser = mAuth.currentUser
    }
}
