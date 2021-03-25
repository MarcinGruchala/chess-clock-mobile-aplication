package com.example.chess_clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.example.chess_clock.databinding.ActivityMainBinding
import java.time.Clock
import java.time.Instant
import java.util.concurrent.TimeUnit

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val time = System.currentTimeMillis()
        var startTime = 0L
        var stopTime = 0L
        var moveDuration = 0L
        var timer1 = Time(0,15,5,0)
        var timer2 = Time(0,15,5,0)
        binding.btnTime1.text = "${timer1.getString(Time.MINUTES)}:${timer1.getString(Time.SECONDS)}"
        binding.btnTime2.text = "${timer2.getString(Time.MINUTES)}:${timer2.getString(Time.SECONDS)}"
        val testTime = toTime(4290017)// 1050017 -> 0:17:30:17
        Log.d("MainActivity",testTime.toString())
        var tmpTime = 0L

        binding.btnTime1.setOnClickListener {
//            startTime = System.currentTimeMillis()



        }

        binding.btnTime2.setOnClickListener {
//            stopTime = System.currentTimeMillis()
//            moveDuration = startTime - stopTime
//            timer2.allToMilliSeconds()
//            tmpTime = timer2.milliSeconds - moveDuration
//            timer2 = toTime(tmpTime)
//            binding.btnTime2.text = "${timer2.minutes}:${timer2.seconds}"
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
}