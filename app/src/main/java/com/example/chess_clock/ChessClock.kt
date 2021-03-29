package com.example.chess_clock

import android.os.CountDownTimer
import android.widget.Button

class ChessClock(
        var whitenButton: Button,
        var blackButton: Button,
        val gameLength: Long,
        val interval: Long
)  {
    enum class Player{White,Black}
    var isOn = false
    var whiteTime = gameLength
    var blackTime = gameLength
    var playerTurn = Player.Black
    var countDownTimer: CountDownTimer? = null

    fun startClocks(){
        when(playerTurn){
            Player.White -> {
                countDownTimer = object : CountDownTimer(whiteTime,interval){
                    override fun onTick(millisUntilFinished: Long) {
                        whiteTime = millisUntilFinished
                        updateUi(Time.toTime(whiteTime), Time.toTime(blackTime))
                    }
                    override fun onFinish() {}
                }

            }
            Player.Black ->{
                countDownTimer = object : CountDownTimer(blackTime,interval){
                    override fun onTick(millisUntilFinished: Long) {
                        blackTime = millisUntilFinished
                        updateUi(Time.toTime(whiteTime), Time.toTime(blackTime))
                    }
                    override fun onFinish() {}
                }

            }
        }
        countDownTimer!!.start()
    }

    fun stopClocks(){
        countDownTimer!!.cancel()
    }

    fun playerUpdate(){
        playerTurn = if (playerTurn==Player.White) Player.Black else Player.White
    }

    private fun updateUi(whiteTime: Time, blackTime: Time){
        whitenButton.text = "${whiteTime.getString(Time.MINUTES)}:${whiteTime.getString(Time.SECONDS)}"
        blackButton.text = "${blackTime.getString(Time.MINUTES)}:${blackTime.getString(Time.SECONDS)}"
    }

}