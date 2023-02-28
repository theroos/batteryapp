package com.example.theroos.batterykot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.theroos.batterykot.R.color.*
import com.example.theroos.batterykot.R.layout.activity_main
import android.content.Intent as Intent1

class MainActivity : AppCompatActivity() {

    var batterystat: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        batterystat = findViewById(R.id.batterypercen)

        registerReceiver(this.mBatteryInfoRecever, IntentFilter(Intent1.ACTION_BATTERY_CHANGED))
    }

    private val mBatteryInfoRecever: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent1?) {
            val level = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)
            //val status = intent!!.getIntExtra(BatteryManager.EXTRA_STATUS,-1)



            if(level <= 10){
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor( this@MainActivity, R.color.Red));
            }
            else if (level <= 20) {
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor( this@MainActivity, R.color.Yellow));
            }
            else if (level <= 80) {
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor( this@MainActivity, R.color.Blue));
            }
            else{
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor( this@MainActivity, R.color.Green));
            }

            //val batteryper = level * 100 / status.toFloat()

            batterystat!!.text = level.toString()+"%"

        }
    }


}