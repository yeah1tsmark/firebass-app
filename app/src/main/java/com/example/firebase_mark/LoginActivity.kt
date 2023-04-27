package com.example.firebase_mark

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var editemail:EditText
    private lateinit var editpass:EditText
    private lateinit var loginbutton:Button
    private lateinit var regbutton:Button
    private lateinit var auth:FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editemail = findViewById(R.id.edtemail)
        editpass = findViewById(R.id.edtpass)
        loginbutton = findViewById(R.id.btnlogin)
        regbutton = findViewById(R.id.btnreg)

        auth = FirebaseAuth.getInstance()

        regbutton.setOnClickListener {
            // navigate user to registration page
            var gotoreg = Intent(this, RegisterActivity::class.java)
            startActivity(gotoreg)
        }

        loginbutton.setOnClickListener {
            var email = editemail.text.toString().trim()
            var pass = editpass.text.toString().trim()

            // VALIDATION
            if (email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "ERROR! Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                        //navigate a use rt a diffdrent page
                        var gotomain = Intent(this,MainActivity::class.java)
                        startActivity(gotomain)
                        // prevent user from going back to login page hence closing the app
                        finish()

                    }else{
                        Toast.makeText(this, "Failed to login!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}