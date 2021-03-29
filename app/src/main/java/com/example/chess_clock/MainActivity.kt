package com.example.chess_clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import com.example.chess_clock.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val btnTime1 = findViewById<Button>(R.id.btnTime1)
        val btnTime2 = findViewById<Button>(R.id.btnTime2)

        var gameLength = 900000L
        var countDownInterval = 1000L
        lateinit var whiteTime: Time
        var whiteTimeRemaining = gameLength

        var chessClock: CountDownTimer? = null

       // var whiteClock = chessClock


        binding.btnTime1.setOnClickListener {
            chessClock = object : CountDownTimer(whiteTimeRemaining,countDownInterval){
                var remainingTime = gameLength
                override fun onTick(millisUntilFinished: Long) {
                    whiteTime = toTime(millisUntilFinished)
                    updateUI(whiteTime)
                    whiteTimeRemaining = millisUntilFinished
                }
                override fun onFinish() {}
            }
            chessClock!!.start()


        }

        binding.btnTime2.setOnClickListener {
            chessClock!!.cancel()
        }
    }

    private  fun toTime(measuredTime: Long): Time{
        var seconds = measuredTime / 1000
        var milliSeconds = measuredTime - seconds * 1000
        var minutes = seconds / 60
        seconds -= minutes * 60
        var hours = minutes / 60
        minutes -= hours * 60
        return Time(hours,minutes,seconds,milliSeconds)
    }

    private fun updateUI(whiteTime: Time){
        binding.btnTime2.text="${whiteTime.getString(Time.MINUTES)}:${whiteTime.getString(Time.SECONDS)}"
    }

    private fun pauseClock(clock: CountDownTimer){
        clock.cancel()
    }
}
