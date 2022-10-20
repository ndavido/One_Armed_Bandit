package com.example.onearmedbandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * This activity allows the user to spin the reels in a slot machine
 * and view the result on the screen
 */

class Instructions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)
    }
}