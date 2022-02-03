package com.example.chosebiggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        buttonLeft.setOnClickListener {
            answerCheck(true)
            assignNumbersToButtons()
        }

        buttonRight.setOnClickListener {
            answerCheck(false)
            assignNumbersToButtons()
        }
    }

    private fun answerCheck(isLeftButtonSelected: Boolean){
        val leftNum = buttonLeft.text.toString().toInt()
        val rightNum = buttonRight.text.toString().toInt()
        val isAnswerCorrect : Boolean = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Change the background colour
            backgroundView.setBackgroundColor(Color.BLUE)
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        // Calling the Random function
        val r = Random
        val leftNum : Int = r.nextInt(99)
        var rightNum : Int = leftNum
        while (rightNum == leftNum){
            rightNum = r.nextInt(99)
        }
        buttonLeft.text = leftNum.toString()
        buttonRight.text = rightNum.toString()
    }
}