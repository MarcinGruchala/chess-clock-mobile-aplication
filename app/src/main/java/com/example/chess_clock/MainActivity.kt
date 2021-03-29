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
        var chessTimer= ChessClock(btnTime1,btnTime2,gameLength,countDownInterval)



        binding.btnTime1.setOnClickListener {
            if (!chessTimer.isOn){
                chessTimer.isOn = true
                chessTimer.blackButton=btnTime1
                chessTimer.whitenButton=btnTime2
                chessTimer.startClocks()
            }
            else{
                chessTimer.stopClocks()
                chessTimer.playerUpdate()
                chessTimer.startClocks()
            }

        }

        binding.btnTime2.setOnClickListener {
            if (!chessTimer.isOn){
                chessTimer.isOn = true
                chessTimer.blackButton=btnTime2
                chessTimer.whitenButton=btnTime1
                chessTimer.startClocks()
            }
            else{
                chessTimer.stopClocks()
                chessTimer.playerUpdate()
                chessTimer.startClocks()
            }

        }
    }
}
