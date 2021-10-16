package com.example.a2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern
import kotlin.math.exp

class PayOptionsActivity : AppCompatActivity() {
    var errorInfo : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_options)
    }

    fun payment(v:View){
        val card_number = findViewById<EditText>(R.id.card_number).text.toString()
        val expiry_date = findViewById<EditText>(R.id.expiry_date).text.toString()

        if (! Pattern.matches("[0-9]{6,8}", card_number)){
            errorInfo = "Card number's length: Minimum length = 6 and Max length = 8"
        } else if (! Pattern.matches("\\d{4}-\\d{2}-\\d{2}", expiry_date)) {
            errorInfo = "Expiry date's format: YYY-MM-DD"
        } else {
            errorInfo = ""
        }

        if (errorInfo == ""){
            val i = Intent(this@PayOptionsActivity, PersonalInformationActivity::class.java)
            startActivity(i)
        } else {
            Toast.makeText(this, errorInfo, Toast.LENGTH_SHORT).show()
        }

    }


}


