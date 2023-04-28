package com.example.firebase_mark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var editcarmodel:EditText
    private lateinit var editcarmake:EditText
    private lateinit var editcarprice:EditText
    private lateinit var butttonuploadimg:Button
    private lateinit var buttonuploaddata:Button
    private lateinit var buttonview:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editcarmodel = findViewById(R.id.edtcarmodel)
        editcarmake = findViewById(R.id.edtcarmake)
        editcarprice = findViewById(R.id.edtcarprice)
        butttonuploadimg = findViewById(R.id.btnuploadimg)
        buttonuploaddata = findViewById(R.id.btnuploaddata)
        buttonview = findViewById(R.id.btnviewcars)

        // initialize
        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.getReference("cars")

        // uploading all data
        buttonuploaddata.setOnClickListener {

            var carmake = editcarmake.text.toString().trim()
            var carmodel = editcarmodel.text.toString().trim()
            var carprice = editcarprice.text.toString().trim()

            // validation
            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()) {
                Toast.makeText(this, "Error! Cannot upload empty fields", Toast.LENGTH_SHORT).show()
            } else {
                // try to upload data
                var usercar = Car(carmake, carmodel, carprice)

                // creating a reference to FirebaseDatabase
                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(
                            this, "Car Data Uploaded Successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this, "Failed tO Save Car Info",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

            }

            // uploading img
            butttonuploadimg.setOnClickListener {


            }


            // viewing uploaded img
            buttonview.setOnClickListener {
                //var user_data = editdata.text.toString().trim()
                //Toast.makeText(this, "user_data", Toast.LENGTH_SHORT).show()
                //databaseRef.setValue(user_data)
            }


        }
    }
}