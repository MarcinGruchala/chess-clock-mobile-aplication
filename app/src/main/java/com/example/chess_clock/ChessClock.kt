package com.example.chess_clock

import android.os.CountDownTimer
import android.widget.Button

class ChessClock(
        val button1: Button,
        val button2: Button,
        val gameLength: Long,
        val interval: Long
)  {
    var isOn = false
    var whiteTime = gameLength
    var blackTime = gameLength
    var countDownTimer: CountDownTimer? = null

    fun startClocks(){
        countDownTimer = object : CountDownTimer(whiteTime,interval){
            override fun onTick(millisUntilFinished: Long) {
                updateUi(Time.toTime(millisUntilFinished))
                whiteTime = millisUntilFinished
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }
        countDownTimer!!.start()

    }

    fun stopClocks(){
        countDownTimer!!.cancel()
    }

    private fun updateUi(whiteTime: Time){
        button2.text = "${whiteTime.getString(Time.MINUTES)}:${whiteTime.getString(Time.SECONDS)}"
        //button2.text = "CZAS"
    }

}