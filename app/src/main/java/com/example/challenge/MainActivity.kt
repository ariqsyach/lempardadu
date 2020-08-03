package com.example.challenge

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaPlayer = MediaPlayer.create(
            this,
            R.raw.ringtone
        )
        btnLogin.setOnClickListener {
            mediaPlayer.start()
            val nama = etNama.text.toString()
            if (etNama.text == null) {
                Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, RollActivity::class.java)
                intent.putExtra("nama", nama)
                startActivity(intent)
            }
        }
        btn_topskor.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, TopScoreActivity::class.java)
            startActivity(intent)

        }
    }
}