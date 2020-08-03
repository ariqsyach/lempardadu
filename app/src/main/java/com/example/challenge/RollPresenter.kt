package com.example.challenge

import android.widget.Toast

class RollPresenter(private val view: RollView) {
    private var score = 0
    fun rollDadu() {
//        repeat(5) {
        val dadu = arrayListOf<Int>(1, 2, 3, 4, 5, 6)
        val result = dadu.random()
//        view.gambarDadu(result)
        if (result == 1 || result == 3 || result == 5) {
            score += 5
        } else if(result == 2 || result == 4 || result == 6) {
            score -= 3
        }
        else{
            Toast.makeText(RollActivity(),"Berhasil Mereset",Toast.LENGTH_LONG).show()
        }
//        }
        view.balik(score,result)
    }
    fun reset(){
        score = 0
        view.balik(score,0)
    }
}