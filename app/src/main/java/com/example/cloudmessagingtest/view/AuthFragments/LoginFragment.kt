package com.example.cloudmessagingtest.view.AuthFragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cloudmessagingtest.R
import com.example.cloudmessagingtest.view.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        checkCurrentUser()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun loginUser(v: View) {
        val email = etLoginEmail.text.toString()
        val password = etLoginPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(activity, "Enter all fields", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(activity, MainActivity::class.java))
                } else {
                    Toast.makeText(activity, "Wrong email/password", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun checkCurrentUser() {
        if (mAuth.currentUser != null) {
            startActivity(Intent(activity, MainActivity::class.java))
        } else return
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setInitialData()
        initListener()
    }

    private fun setInitialData() {
        setTitle()
    }
    private fun setTitle() {
        activity!!.title = "Login"
    }

    private fun initListener() {
        btnLoginSignIn.setOnClickListener {
            loginUser(it)
        }

        tvLoginToRegistration.setOnClickListener {
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.auth_container, RegistrationFragment())
                .commit()
        }
    }
}
