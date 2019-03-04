package com.example.cloudmessagingtest.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        when (id) {
            R.id.menuSignOut -> {
                mAuth.signOut()
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
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
