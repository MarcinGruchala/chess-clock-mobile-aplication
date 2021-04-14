package com.example.chess_clock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.preference.PreferenceManager
import com.example.chess_clock.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Settings.load(PreferenceManager.getDefaultSharedPreferences(applicationContext))
    }

    override fun onResume() {
        super.onResume()
        val btnTime1 = findViewById<Button>(R.id.btnTime1)
        val btnTime2 = findViewById<Button>(R.id.btnTime2)

        var gameTime = Settings.getGameTime()
        var gameTimeIncrement = Settings.getGameTimeIncrement()
        Log.d("MainActivity", "Increment setting: $gameTimeIncrement")

        var countDownInterval = 1000L
        var chessTimer= ChessClock(btnTime1,btnTime2,gameTime,gameTimeIncrement,countDownInterval)

        binding.btnTime1.text = "${Time.toTime(gameTime).getString(Time.MINUTES)}:${Time.toTime(gameTime).getString(Time.SECONDS)}"
        binding.btnTime2.text = "${Time.toTime(gameTime).getString(Time.MINUTES)}:${Time.toTime(gameTime).getString(Time.SECONDS)}"

        binding.btnSettings.setOnClickListener {
            Intent(this,SettingsActivity::class.java).also {
                startActivity(it)
            }
        }

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
