package com.example.hello

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.net.PasswordAuthentication

class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivityMainBinding


    @SuppressLint("MissingInflatedId")

    lateinit var tvLogin: TextView
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilPasswordConfirmation: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etPasswordConfirmation: TextInputEditText
    lateinit var btnSignUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.id)

        setContentView(R.layout.activity_main)
        castView()
    }

    override fun onResume() {
        super.onResume()
//        tvLogin.setOnClickListener {
//            val intent = Intent(this, LogInActivity::class.java)
//            startActivity(intent)
//        }
//        btnSignUp.setOnClickListener {
//            clearErrors()
//            validateSignUp()

//        binding.tvLogin.setOnClick{

        }
    }

    fun castView() {
        tvLogin = findViewById(R.id.tvLogin)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassWord)
        tilPasswordConfirmation = findViewById(R.id.tilPassWordConfirmation)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassWord)
        etPasswordConfirmation = findViewById(R.id.etPassWordConfirmation)
        btnSignUp = findViewById(R.id.btnSignUp)

//        etFirstName.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//        })

    }

    fun validateSignUp() {
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmation = etPasswordConfirmation.text.toString()
        var error = false

        if (firstName.isBlank()) {
            tilFirstName.error = "First Name is required"
            error = true
        }
        if (lastName.isBlank()) {
            tilLastName.error = "Last Name is required"
            error = true
        }
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            tilPassword.error = "Please Enter your Password"
            error = true
        }
        if (confirmation.isBlank()) {
            tilPasswordConfirmation.error = "Input Password  "
            error = true
        }
        if (confirmation != password) {
            tilPasswordConfirmation.error = "Password and confirmation do not Match"
            error = true
        }
        if (!error) {
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG).show()
        }
    }

    fun clearErrors() {
        tilFirstName.error = null
        tilLastName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilPasswordConfirmation.error = null
    }
}