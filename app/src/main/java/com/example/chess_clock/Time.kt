package com.example.chess_clock

import android.icu.util.TimeUnit

class Time(
    var hours: Long,
    var minutes: Long,
    var seconds: Long,
    var milliSeconds: Long
) {

    companion object{
        val HOURS = 1
        val MINUTES = 2
        val SECONDS = 3
        val MILLISECONDS = 4

        fun toTime(measuredTime: Long): Time{
            var seconds = measuredTime / 1000
            var milliSeconds = measuredTime - seconds * 1000
            var minutes = seconds / 60
            seconds -= minutes * 60
            var hours = minutes / 60
            minutes -= hours * 60
            return Time(hours,minutes,seconds,milliSeconds)
        }

    }


    fun getString(timeUnit: Int): String{
        when(timeUnit){
            HOURS -> {
                if(hours>9)
                    return "${hours}"
                else
                    return "0$hours"
            }
            MINUTES -> {
                if(minutes>9)
                    return "$minutes"
                else
                    return "0$minutes"
            }
            SECONDS -> {
                if(seconds>9)
                    return "$seconds"
                else
                    return "0$seconds"
            }
            MILLISECONDS -> {
                if(milliSeconds/10>9)
                    return "${milliSeconds/10}"
                else
                    return "0${milliSeconds/10}"
            }
            else -> return ""
        }
    }

    fun allToMilliSeconds(){
        minutes += hours*60
        hours = 0
        seconds += minutes*60
        minutes = 0
        milliSeconds += seconds * 1000
        seconds = 0
    }

//    fun allToOneUnit(timeUnit: TimeUnit){
//
//    }

    override fun toString(): String {
        return "$hours:$minutes:$seconds:$milliSeconds"
    }

}