package com.example.challenge

class RollPresenter(private val view :RollView) {
    val score = 0
    fun rollDadu() {
        repeat(5) {
            val dadu = arrayListOf<Int>(1, 2, 3, 4, 5, 6)
            var result = dadu.random()

            if (result == 1 || result == 3 || result == 5) {
                score + 5
            } else {
                score - 3
            }
        }
        view.balik(score)
    }
}