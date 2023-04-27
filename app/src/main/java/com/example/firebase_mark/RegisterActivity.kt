package com.example.firebase_mark

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var editnamereg:EditText
    private lateinit var editregemail:EditText
    private lateinit var editregpass:EditText
    private lateinit var buttoncreateuser:Button

    // initialize firebase
    private lateinit var auth:FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editnamereg = findViewById(R.id.edtnamereg)
        editregemail = findViewById(R.id.edtregemail)
        editregpass = findViewById(R.id.edtregpass)
        buttoncreateuser = findViewById(R.id.btncreateuser)

        //initialize again
        auth = FirebaseAuth.getInstance()

        buttoncreateuser.setOnClickListener {

            var name = editnamereg.text.toString().trim()
            var email = editregemail.text.toString().trim()
            var pass = editregpass.text.toString().trim()

            // VALIDATION*
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Error! Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()

                        // navigate back to login
                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)

                    }else{
                        Toast.makeText(this, "Failed to create user", Toast.LENGTH_SHORT).show()
                    }
                }


            }
        }
    }
}