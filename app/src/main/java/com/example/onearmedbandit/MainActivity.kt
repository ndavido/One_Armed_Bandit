package com.example.onearmedbandit

/**
 * Mobile Integration CA1
 *
 * Student ID : D00239107
 * Student Name : Dawid Nalepa
 * Class Group : SD3b
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * This activity allows the user to spin the reels in a slot machine
 * and view the result on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{ spinReel() }
    }

    private fun spinReel() {
        /** Create a new Reel object with 4 images and spin it */


        /** Find the ImageView in the layout */


        /** Determine which drawable resource ID to use based on the Reel spin */


        /** Update the ImageView with the correct drawable resource ID */


        /** Update the content description */

    }
}


class Reel(private val numImages: Int){
    fun spin(): Int{
        return (1..numImages).random()
    }
}