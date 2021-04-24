package com.example.chess_clock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.preference.PreferenceManager
import com.example.chess_clock.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    lateinit var btnTime1: Button
    lateinit var btnTime2: Button
    lateinit var chessClock: ChessClock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Settings.load(PreferenceManager.getDefaultSharedPreferences(applicationContext))
        btnTime1 = findViewById<Button>(R.id.btnTime1)
        btnTime2 = findViewById<Button>(R.id.btnTime2)
        chessClock = ChessClock()
        
    }


    override fun onResume() {
        super.onResume()

        if (!chessClock.isOn || Settings.newSettings) {
            chessClock.updateWithSettings()
        }
        else{
            chessClock.run()
        }

        updateClockButtons()

        binding.btnSettings.setOnClickListener {
            Intent(this,SettingsActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRestart.setOnClickListener {
            chessClock.restart()
            updateClockButtons()
        }

        binding.btnRunControl.setOnClickListener {
            if (chessClock.onPause){
                chessClock.pause()
            }
            else{
                chessClock.run()
            }
        }

        binding.btnTime1.setOnClickListener {
            if (!chessClock.isOn){
                chessClock.startGame(btnTime2,btnTime1)
            }
            else{
                chessClock.handleTurn()
            }
        }

        binding.btnTime2.setOnClickListener {
            if (!chessClock.isOn){
                chessClock.startGame(btnTime1,btnTime2)
            }
            else{
                chessClock.handleTurn()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        chessClock.pause()
    }

    private fun updateClockButtons(){
        binding.btnTime1.text = "${Time.toTime(chessClock.gameTime).getString(Time.MINUTES)}:${Time.toTime(chessClock.gameTime).getString(Time.SECONDS)}"
        binding.btnTime2.text = "${Time.toTime(chessClock.gameTime).getString(Time.MINUTES)}:${Time.toTime(chessClock.gameTime).getString(Time.SECONDS)}"
    }
}
