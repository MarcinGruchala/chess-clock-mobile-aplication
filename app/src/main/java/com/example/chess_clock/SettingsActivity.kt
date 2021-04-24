package com.example.chess_clock

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.CheckBoxPreference
import androidx.preference.Preference
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {
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
         Settings.gameTime = sharedPreferences.getString("gameTime","10min")
         Settings.gameTimeIncrement = sharedPreferences.getString("gameTimeIncrement", "0s")
         //Settings.newSettings = true  TO TU NIE MOŻE BYĆ
     }
}