package com.example.firebase_mark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var editdata:EditText
    private lateinit var savebutton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editdata = findViewById(R.id.edtdata)
        savebutton = findViewById(R.id.btnsave)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference

        savebutton.setOnClickListener {
            var user_data = editdata.text.toString().trim()
            //Toast.makeText(this, "user_data", Toast.LENGTH_SHORT).show()
            databaseRef.setValue(user_data)

        }


    }
}