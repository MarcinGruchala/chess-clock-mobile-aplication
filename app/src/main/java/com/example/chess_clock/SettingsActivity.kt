package com.example.chess_clock

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

 class SettingsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(findViewById(R.id.settings_toolbar))
        supportFragmentManager.beginTransaction().replace(R.id.fragmentSettings, SettingsFragment()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemGoBack -> {
                updateSettings()
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateSettings(){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        Settings.oneMin = sharedPreferences.getBoolean("oneMin",true)
        Settings.twoMin = sharedPreferences.getBoolean("twoMin", false)
        Settings.threeMin = sharedPreferences.getBoolean("threeMin", false)
        Settings.fiveMin = sharedPreferences.getBoolean("fiveMin", false)
        Settings.tenMin = sharedPreferences.getBoolean("tenMin",false)
        Settings.fifteenMin = sharedPreferences.getBoolean("fifTeen", false)
    }
}