package com.example.a2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class PersonalInformationActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)
    }
    fun job_done(v:View){
        sharedPreferences = this.getSharedPreferences("com.example.a2", Context.MODE_PRIVATE)

        val full_name = findViewById<EditText>(R.id.full_name).text.toString()
        val address = findViewById<EditText>(R.id.address).text.toString()
        val city = findViewById<EditText>(R.id.city).text.toString()
        val country = findViewById<EditText>(R.id.country).text.toString()
        val postal_code = findViewById<EditText>(R.id.postal_code).text.toString()
        val telephone_number = findViewById<EditText>(R.id.telephone_number).text.toString()
        val email = findViewById<EditText>(R.id.email).text.toString()
        sharedPreferences.edit().putString(
            "full_name", full_name
        ).apply()
        sharedPreferences.edit().putString(
            "address", address
        ).apply()
        sharedPreferences.edit().putString(
            "city", city
        ).apply()
        sharedPreferences.edit().putString(
            "country", country
        ).apply()



        val i = Intent(this@PersonalInformationActivity, SummaryActivity::class.java)
        startActivity(i)
    }
}