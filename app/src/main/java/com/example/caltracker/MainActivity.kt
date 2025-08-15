package com.example.caltracker

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val logsButton = findViewById<Button>(R.id.logs)
        logsButton.setOnClickListener {
            val intent = Intent(this, LogsActivity::class.java)
            startActivity(intent)
        }

        val profileButton = findViewById<Button>(R.id.profile)
        profileButton.setOnClickListener {
             val intent = Intent(this, ProfileActivity::class.java)
             startActivity(intent)
        }
        val calculateButton = findViewById<Button>(R.id.calculate)
        calculateButton.setOnClickListener {
           val intent = Intent(this, CalculateActivity::class.java)
           startActivity(intent)
        }
    }
}



