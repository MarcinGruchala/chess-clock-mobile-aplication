package com.example.chess_clock

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.chess_clock.databinding.ActivitySettingsBinding
import kotlin.coroutines.coroutineContext

object Settings {
    var gameTime: String? = "10min"
    var gameTimeIncrement: String? = "0s"
    var newSettings = false


    fun load(sharedPreferences: SharedPreferences){
        gameTime = sharedPreferences.getString("gameTime", "10min")
        gameTimeIncrement = sharedPreferences.getString("gameTimeIncrement", "0s")
    }

    fun getGameTime(): Long {
        return when(gameTime){
            "1min" -> 60000L
            "3min" -> 180000L
            "5min" -> 300000L
            "10min" -> 600000L
            "15min" -> 900000L
            else -> 0L
        }
    }

    fun getGameTimeIncrement(): Long {
        return when(gameTimeIncrement){
            "0s" -> 0L
            "1s" -> 1000L
            "2s" -> 2000L
            "5s" -> 5000L
            "10s" -> 10000L
            "45s" -> 45000L
            else -> 0L
        }
    }
}