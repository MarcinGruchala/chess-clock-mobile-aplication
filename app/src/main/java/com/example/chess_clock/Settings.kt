package com.example.chess_clock

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.chess_clock.databinding.ActivitySettingsBinding
import kotlin.coroutines.coroutineContext

object Settings {
    var oneMin = true
    var twoMin = false
    var threeMin = false
    var fiveMin = false
    var tenMin =  false
    var fifteenMin = false

    fun load(sharedPreferences: SharedPreferences){
        oneMin = sharedPreferences.getBoolean("oneMin", true)
        twoMin = sharedPreferences.getBoolean("twoMin", false)
        threeMin = sharedPreferences.getBoolean("threeMin", false)
        fiveMin = sharedPreferences.getBoolean("fiveMin", false)
        tenMin = sharedPreferences.getBoolean("tenMin",false)
        fifteenMin = sharedPreferences.getBoolean("fifteenMin", false)
    }

    fun getGameTime(): Long{
        if(oneMin){
            return 60000L
        }
        else if (twoMin){
            return  120000L
        }
        else if(threeMin){
            return 180000L
        }
        else if(fiveMin){
            return 300000L
        }
        else if (tenMin){
            return 600000L
        }
        else if (fifteenMin){
            return 900000L
        }
        else{
            return  0L
        }
    }
}