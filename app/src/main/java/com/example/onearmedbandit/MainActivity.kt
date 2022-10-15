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
import android.widget.ImageView

/**
 * This activity allows the user to spin the reels in a slot machine
 * and view the result on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinReel: Button = findViewById(R.id.button)
        spinReel.setOnClickListener{ spinReel() }
    }

    private fun spinReel() {
        /** Create a new Reel object with 4 images and spin it */
        val reel1 = Reel(4)
        val reel2 = Reel(4)
        val reel3 = Reel(4)

        val reelSpin1 = reel1.spin()
        val reelSpin2 = reel1.spin()
        val reelSpin3 = reel1.spin()

        /** Find the ImageView in the layout */
        val reelImage1: ImageView = findViewById(R.id.imageView)
        val reelImage2: ImageView = findViewById(R.id.imageView2)
        val reelImage3: ImageView = findViewById(R.id.imageView3)

        /** Determine which drawable resource ID to use based on the Reel spin */
        val drawableResource1 = when (reelSpin1) {
            1 -> R.drawable.strawberry_slot_images
            2 -> R.drawable.apple_slot_images
            3 -> R.drawable.kiwi_slot_images
            else -> R.drawable.pineapple_slot_images
        }

        val drawableResource2 = when (reelSpin2) {
            1 -> R.drawable.strawberry_slot_images
            2 -> R.drawable.apple_slot_images
            3 -> R.drawable.kiwi_slot_images
            else -> R.drawable.pineapple_slot_images
        }

        val drawableResource3 = when (reelSpin3) {
            1 -> R.drawable.strawberry_slot_images
            2 -> R.drawable.apple_slot_images
            3 -> R.drawable.kiwi_slot_images
            else -> R.drawable.pineapple_slot_images
        }
        /** Update the ImageView with the correct drawable resource ID */
        reelImage1.setImageResource(drawableResource1)
        reelImage2.setImageResource(drawableResource2)
        reelImage3.setImageResource(drawableResource3)

        /** Update the content description */
        reelImage1.contentDescription = reelSpin1.toString()
        reelImage2.contentDescription = reelSpin2.toString()
        reelImage3.contentDescription = reelSpin3.toString()


    }
}


class Reel(private val numImages: Int){
    fun spin(): Int{
        return (1..numImages).random()
    }
}