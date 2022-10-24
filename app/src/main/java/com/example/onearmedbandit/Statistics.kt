package com.example.onearmedbandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

/**
 * This activity allows the user to spin the reels in a slot machine
 * and view the result on the screen
 */

class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        Log.d("DL","in Statistics Page .. onCreate()")

        /** Get the Intent that started this activity and extract the string */
        val totalWins = intent.getStringExtra(TOTAL_WINS)
        Log.d("DL","Total Wins = $totalWins")

        val totalSpins = intent.getStringExtra(TOTAL_SPINS)
        Log.d("DL","Total Spins = $totalSpins")

        val winSpinPerc = intent.getStringExtra(WIN_SPIN_PERC)
        Log.d("DL","Win/Spin Percentage = $winSpinPerc")

        /** Capture the layout's TextView and set the string as its text */
        val wins = findViewById<TextView>(R.id.textView).apply {
            text = totalWins
        }
        val spins = findViewById<TextView>(R.id.textView2).apply {
            text = totalSpins
        }
        val winSpinP = findViewById<TextView>(R.id.textView3).apply {
            text = winSpinPerc
        }
    }
}