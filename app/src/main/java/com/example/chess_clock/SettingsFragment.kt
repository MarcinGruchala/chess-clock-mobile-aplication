package com.example.chess_clock

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.core.util.rangeTo
import androidx.preference.*
import kotlin.math.log

class SettingsFragment : PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}