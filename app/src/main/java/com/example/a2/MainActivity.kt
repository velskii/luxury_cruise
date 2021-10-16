package com.example.a2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnBook_clicked(v:View) {
        val i = Intent(this@MainActivity, CruiseTypesActivity::class.java)
        startActivity(i);
    }
}