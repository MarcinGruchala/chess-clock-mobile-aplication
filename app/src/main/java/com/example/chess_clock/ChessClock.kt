package com.example.chess_clock

import android.os.CountDownTimer
import android.widget.Button

class ChessClock(
        val button1: Button,
        val button2: Button,
        val gameLength: Long,
        val interval: Long
) : CountDownTimer(gameLength,interval) {
    override fun onTick(millisUntilFinished: Long) {
        updateUi()
    }

    override fun onFinish() {
        TODO("Not yet implemented")
    }

    private fun updateUi(){
        button1.text = "CZAS"
        button2.text = "CZAS"
    }

}