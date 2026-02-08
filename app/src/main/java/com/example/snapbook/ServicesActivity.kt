package com.example.snapbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        // Back button in the purple header
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Service item clicks
        findViewById<LinearLayout>(R.id.serviceWedding).setOnClickListener {
            Toast.makeText(this, "Wedding Photography selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.serviceEvent).setOnClickListener {
            Toast.makeText(this, "Event Photography selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.servicePortrait).setOnClickListener {
            Toast.makeText(this, "Portrait Photography selected", Toast.LENGTH_SHORT).show()
        }

        // Inside ServicesActivity.kt onCreate
        findViewById<LinearLayout>(R.id.serviceProduct).setOnClickListener {
            Toast.makeText(this, "Product Photography selected", Toast.LENGTH_SHORT).show()
        }
    }
}