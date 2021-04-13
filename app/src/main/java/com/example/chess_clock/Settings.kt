package com.example.chess_clock

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.chess_clock.databinding.ActivitySettingsBinding
import kotlin.coroutines.coroutineContext

object Settings {
    var gameTime: String? = "10min"


    fun load(sharedPreferences: SharedPreferences){
        gameTime = sharedPreferences.getString("gameTime", "10min")
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
}