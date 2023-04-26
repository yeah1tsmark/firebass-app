package com.example.firebase_mark

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var editemail:EditText
    private lateinit var editpass:EditText
    private lateinit var loginbutton:Button
    private lateinit var regbutton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editemail = findViewById(R.id.edtemail)
        editpass = findViewById(R.id.edtpass)
        loginbutton = findViewById(R.id.btnlogin)
        regbutton = findViewById(R.id.btnreg)

        regbutton.setOnClickListener {
            // navigate user to registration page
            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)
        }

        loginbutton.setOnClickListener {
            // verify
        }
    }
}