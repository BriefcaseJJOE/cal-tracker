package com.example.caltracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caltracker.ui.theme.CalTrackerTheme


class CalculateActivity : ComponentActivity() {
    lateinit var calculateButton: Button
    lateinit var editTextAge: EditText
    lateinit var editTextHeight: EditText
    lateinit var editTextWeight: EditText
    lateinit var radioGroupGender: RadioGroup

    lateinit var radioGroupActivity: RadioGroup

    lateinit var tdeeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate)

        calculateButton = findViewById(R.id.buttonCalculate)
        editTextAge = findViewById(R.id.editTextAge)
        editTextHeight = findViewById(R.id.editTextHeight)
        editTextWeight = findViewById(R.id.editTextWeight)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        radioGroupActivity = findViewById(R.id.radioGroupActivity)
        tdeeButton = findViewById(R.id.buttonTDEE)

        radioGroupGender.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            val gender = radioButton.text.toString()

            calculateButton.setOnClickListener {

                val age = editTextAge.text.toString().toInt()
                val height = editTextHeight.text.toString().toInt()
                val weight = editTextWeight.text.toString().toInt()
                val bmr = calculateBMR(age, height, weight, gender)
                val textViewResult = findViewById<TextView>(R.id.textViewResult)
                textViewResult.text = bmr.toString()

            radioGroupActivity.setOnCheckedChangeListener { group, checkedId ->
                val radioButton = findViewById<RadioButton>(checkedId)
                val activity = radioButton.text.toString()

                tdeeButton.setOnClickListener {
                    val tdee = calculateTDEE(bmr, activity)
                    val textViewResultTDEE = findViewById<TextView>(R.id.textViewResultTDEE)
                    textViewResultTDEE.text = tdee.toString()
                }
            }
            }
            }
        }
        }

private fun CalculateActivity.calculateTDEE(bmr: Double, activity: String): Double {
    if (activity == "Sedentary (little or no exercise)") {
        return bmr * 1.2
        } else if (activity == "Lightly active (light exercise/sports 1-3 days/week)") {
        return bmr * 1.375
        } else if (activity == "Moderately active (moderate exercise/sports 3-5 days/week)") {
        return bmr * 1.55
        } else if (activity == "Very active (hard exercise/sports 6-7 days a week)") {
        return bmr * 1.725
        } else if (activity == "Extra active (very hard exercise/sports (hard physical job))") {
        return bmr * 1.9
        } else {
        return 0.0

}


}

    private fun CalculateActivity.calculateBMR(
        age: Int,
        height: Int,
        weight: Int,
        gender: String
    ): Double {
        if (gender == "M") {
            return 66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age)
        } else if (gender == "F") {
            return 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age)
        }
        return 0.0
    }


