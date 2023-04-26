package com.example.firebase_mark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var editnamereg:EditText
    private lateinit var editregemail:EditText
    private lateinit var editregpass:EditText
    private lateinit var buttoncreateuser:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editnamereg = findViewById(R.id.edtnamereg)
        editregemail = findViewById(R.id.edtregemail)
        editregpass = findViewById(R.id.edtregpass)
        buttoncreateuser = findViewById(R.id.btncreateuser)

        buttoncreateuser.setOnClickListener {
        }
    }
}