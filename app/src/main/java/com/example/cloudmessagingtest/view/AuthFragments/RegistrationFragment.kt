package com.example.cloudmessagingtest.view.AuthFragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.cloudmessagingtest.R
import com.example.cloudmessagingtest.model.User
import com.example.cloudmessagingtest.view.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {

    lateinit var mAuth: FirebaseAuth
    lateinit var db: FirebaseDatabase

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

    private fun setInitialData() {
        setTitle()
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
    }


    private fun initListener() {
        btnRegisterNewUser.setOnClickListener {
            val username = etRegisterUsername.text.toString()
            val email = etRegisterEmail.text.toString()
            val password = etRegisterPassword.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Enter all fields!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val currentUser = mAuth.currentUser
                        val usersRef = db.reference.child("Users")

                        val user = User(currentUser?.uid.toString(), username, email)
                        usersRef.setValue(user)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(context, MainActivity::class.java))
                                }
                            }
                            .addOnFailureListener {
                                Toast.makeText(context,"Can`t set user into database",Toast.LENGTH_SHORT).show()
                            }
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context,"Can`t create user",Toast.LENGTH_SHORT).show()
                }
        }

        tvRegisterToLogin.setOnClickListener {
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.auth_container, LoginFragment())
                .commit()
        }
    }

    private fun setTitle() {
        activity!!.title = getString(R.string.Registration)
    }
}
