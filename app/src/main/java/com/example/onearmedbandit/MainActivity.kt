package com.example.onearmedbandit

/**
 * Mobile Integration CA1
 *
 * Student ID : D00239107
 * Student Name : Dawid Nalepa
 * Class Group : SD3b
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.onearmedbandit.databinding.ActivityMainBinding
import kotlin.math.roundToInt

const val TOTAL_WINS = "totalWins"
const val TOTAL_SPINS = "totalSpins"
const val WIN_SPIN_PERC = "winSpinPerc"

/**
 * This activity allows the user to spin the reels in a slot machine
 * and view the result on the screen
 */

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("DL","in Main Activity .. onCreate()")

        /** Spin Button */
        binding.spinButton.setOnClickListener{ spinReel() }

        /** Button re-directing to the Game Instruction Page */
        binding.infoButton.setOnClickListener{
            val intent = Intent(this, Instructions::class.java)
            startActivity(intent)
        }

        /** Button re-directing to the Game Statistics Page */
        binding.statsButton.setOnClickListener {
            val intent = Intent(this, Statistics::class.java).apply {
                putExtra(TOTAL_SPINS, totalSpins.toString())
                putExtra(TOTAL_WINS, totalWins.toString())
                putExtra(WIN_SPIN_PERC, winSpinPerc.toString())
            }
            startActivity(intent)
        }
    }

    /** Initialize variables for statistics*/
    var totalSpins = 0
    var totalWins = 0
    var winSpinPerc = 0

    private fun spinReel() {
        totalSpins++
        /** Create a new Reel object with 4 images and spin it */
        val reel1 = Reel(4)
        val reel2 = Reel(4)
        val reel3 = Reel(4)

        val reelSpin1 = reel1.spin()
        Log.d("DL","Reel 1 = $reelSpin1")

        val reelSpin2 = reel2.spin()
        Log.d("DL","Reel 2 = $reelSpin2")

        val reelSpin3 = reel3.spin()
        Log.d("DL","Reel 3 = $reelSpin3")

        /** Find the ImageView in the layout */
        val reelImage1: ImageView = binding.imageView
        val reelImage2: ImageView = binding.imageView2
        val reelImage3: ImageView = binding.imageView3

        /** Using a function to set the drawable resource */
        val drawableResource1 = reelImageSetter(reelSpin1)
        val drawableResource2 = reelImageSetter(reelSpin2)
        val drawableResource3 = reelImageSetter(reelSpin3)

        /** Update the ImageView with the correct drawable resource ID */
        reelImage1.setImageResource(drawableResource1)
        reelImage2.setImageResource(drawableResource2)
        reelImage3.setImageResource(drawableResource3)

        /** Update the content description */
        reelImage1.contentDescription = reelSpin1.toString()
        reelImage2.contentDescription = reelSpin2.toString()
        reelImage3.contentDescription = reelSpin3.toString()

        /** Update info card on whether play Won or should try again */
        val winTry: ImageView = findViewById(R.id.winOrLose)
        if (drawableResource1 == drawableResource2 && drawableResource1 == drawableResource3) {
            winTry.setImageResource(R.drawable.youwin__1_)
            totalWins++
        } else {
            winTry.setImageResource(R.drawable.tryagain)
        }

        /** Formula for the Win/Spin Percentage */
        winSpinPerc = ((totalWins.toDouble() / totalSpins.toDouble()) * 100).roundToInt()

        /** Takes calculations and passes it through to the string */
        binding.totalSpins.text = getString(R.string.TotalSpins, totalSpins)
        binding.totalWins.text = getString(R.string.TotalWins, totalWins)
        binding.winSpinRatio.text = getString(R.string.WinSpinRatio, winSpinPerc)
    }

    /** Determine which drawable resource ID to use based on the Reel spin */
    private fun reelImageSetter(reelSpin:Int): Int {
        val drawableResource = when (reelSpin) {
            1 -> R.drawable.strawberry_slot_images
            2 -> R.drawable.apple_slot_images
            3 -> R.drawable.kiwi_slot_images
            else -> R.drawable.pineapple_slot_images
        }
        return drawableResource
    }
}

/** Creates a reel object */
class Reel(private val numImages: Int) {
    fun spin(): Int {
        return (1..numImages).random()
    }
}