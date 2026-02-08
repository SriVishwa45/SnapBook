package com.example.snapbook

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnBookNow = findViewById<Button>(R.id.btnBookNow)
        val spinner = findViewById<Spinner>(R.id.spinnerServices)

        // Setup Spinner Services
        val services = arrayOf("Select a service", "Wedding Photography", "Event Photography", "Product Photography", "Portrait Photography")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, services)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnBack.setOnClickListener { finish() }

        btnBookNow.setOnClickListener {
            if (spinner.selectedItemPosition == 0) {
                Toast.makeText(this, "Please select a service type", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirm Booking")
            builder.setMessage("Do you want to confirm your booking for ${spinner.selectedItem}?")
            builder.setPositiveButton("Yes") { _, _ ->
                sendSuccessNotification()
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            builder.show()
        }
    }

    private fun sendSuccessNotification() {
        val channelId = "booking_success"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Booking Notifications", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Booking Success!")
            .setContentText("Your photography session has been booked.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
    }
}