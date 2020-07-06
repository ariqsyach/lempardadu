package com.example.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener{
            val nama = etNama.text.toString()
            val intent = Intent(this, RollActivity::class.java)
            startActivity(intent)
        }
    }
}