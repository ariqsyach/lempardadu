package com.example.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roll.*

class RollActivity : AppCompatActivity(),RollView {
    private val presenter : RollPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll)
      btn_roll.setOnClickListener{
          presenter.rolldadu()
      }
    }

    override fun balik(skor: Int) {
        tv_roll.text = skor.toString()
    }
}