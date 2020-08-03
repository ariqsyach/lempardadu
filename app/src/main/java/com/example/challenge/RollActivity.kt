package com.example.challenge

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_roll.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class RollActivity : AppCompatActivity(), RollView {

    private lateinit var presenter: RollPresenter
    private lateinit var repository: ItemRepository
    private lateinit var database: RollDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaPlayer = MediaPlayer.create(this,
            R.raw.ringtone
        )
        presenter = RollPresenter(this)
        setContentView(R.layout.activity_roll)
        val username = intent.getStringExtra("nama")
        tv_user.text = username
        btn_roll.setOnClickListener {
            mediaPlayer.start()
            presenter.rollDadu()
        }
        btn_reset.setOnClickListener {
            mediaPlayer.start()
            reset()
        }
        btn_topscore.setOnClickListener{
            val intent = Intent(this, TopScoreActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    @InternalCoroutinesApi
    override fun balik(skor: Int, angka: Int?) {
        database = RollDatabase.getDatabase(this)
        repository = ItemRepository(database.itemDao())
        val gambar = when (angka) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        if (tv_dice_1.text == "") {
            tv_dice_1.text = angka.toString()
            iv_dice_1.setImageResource(gambar)
            tv_total.text = "Total = ${skor}"
        } else if (tv_dice_2.text == "") {
            tv_dice_2.text = angka.toString()
            iv_dice_2.setImageResource(gambar)
            tv_total.text = "Total = ${skor}"
        } else if (tv_dice_3.text == "") {
            tv_dice_3.text = angka.toString()
            iv_dice_3.setImageResource(gambar)
            tv_total.text = "Total = ${skor}"
        } else if (tv_dice_4.text == "") {
            tv_dice_4.text = angka.toString()
            iv_dice_4.setImageResource(gambar)
            tv_total.text = "Total = ${skor}"
        } else if (tv_dice_5.text == "") {
            tv_dice_5.text = angka.toString()
            iv_dice_5.setImageResource(gambar)
            tv_total.text = "Total = ${skor}"
            val username = intent.getStringExtra("nama")
            val dadu = Dadu(skor, username)
            GlobalScope.launch {
                repository.insertData(dadu)
            }
        } else {
            Toast.makeText(this, "Anda Sudah Memainkan 5 Kali", Toast.LENGTH_LONG).show()
        }
    }

    private fun reset() {
        presenter.reset()
        tv_dice_1.text = ""
        tv_dice_2.text = ""
        tv_dice_3.text = ""
        tv_dice_4.text = ""
        tv_dice_5.text = ""
        iv_dice_1.setImageResource(R.drawable.empty_dice)
        iv_dice_2.setImageResource(R.drawable.empty_dice)
        iv_dice_3.setImageResource(R.drawable.empty_dice)
        iv_dice_4.setImageResource(R.drawable.empty_dice)
        iv_dice_5.setImageResource(R.drawable.empty_dice)

    }

}