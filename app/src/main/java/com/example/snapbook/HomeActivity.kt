package com.example.snapbook

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. Back Arrow Logic
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Returns to MainActivity
        }

        // 2. Services Card
        findViewById<LinearLayout>(R.id.cardServices).setOnClickListener {
            val intent = Intent(this, ServicesActivity::class.java)
            startActivity(intent)
        }

        // 3. Book Session Card - UPDATED INTENT
        findViewById<LinearLayout>(R.id.cardBook).setOnClickListener {
            Toast.makeText(this, "Opening Booking Page...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
        }

        // 4. Gallery Card
        findViewById<LinearLayout>(R.id.cardGallery).setOnClickListener {
            Toast.makeText(this, "Opening Gallery...", Toast.LENGTH_SHORT).show()
        }

        // 5. Contact Card
        findViewById<LinearLayout>(R.id.cardContact).setOnClickListener {
            Toast.makeText(this, "Opening Contact Info...", Toast.LENGTH_SHORT).show()
        }
    }
}