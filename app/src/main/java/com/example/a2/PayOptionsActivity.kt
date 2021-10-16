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
    var errorCode : Int = 0
    var errorInfo : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_options)

        val card_number = findViewById<EditText>(R.id.card_number) as EditText
        card_number.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
//                error = Pattern.matches("[0-9]{6,8}", p0?.toString()).toString()
                if (! Pattern.matches("[0-9]{6,8}", p0?.toString()) ) {
                    errorInfo = "Card number's length: Minimum length = 6 and Max length = 8\n"
                }else{
                    errorInfo = ""
                    errorCode += 1
                }
            }
        })
        card_number.error = if (Pattern.matches("[0-9]{6,8}", card_number.toString())) null else "Card number's length: Minimum length = 6 and Max length = 8"

        val expiry_date = findViewById<EditText>(R.id.expiry_date) as EditText
        expiry_date.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {
//                error = Pattern.matches("\\d{4}-\\d{2}-\\d{2}", p0?.toString()).toString()
                if (! Pattern.matches("\\d{4}-\\d{2}-\\d{2}", p0?.toString()) ) {
                    errorInfo = "Expiry date's format: YYY-MM-DD\n"
                }else{
                    errorInfo = ""
                    errorCode += 1
                }
            }
        })
        expiry_date.error = if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", expiry_date.toString())) null else "Expiry date's format: YYY-MM-DD"
    }


    fun payment(v:View){
        if (errorCode == 2){
            val i = Intent(this@PayOptionsActivity, PersonalInformationActivity::class.java)
            startActivity(i)
        } else {
            Toast.makeText(this, errorInfo, Toast.LENGTH_SHORT).show()
        }

    }


}


