package com.example.snapbook

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Binding views
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val signIn = findViewById<Button>(R.id.btnSignIn)

        // Changed to LinearLayout for custom design
        val google = findViewById<LinearLayout>(R.id.btnGoogle)
        val apple = findViewById<LinearLayout>(R.id.btnApple)
        val signup = findViewById<TextView>(R.id.txtSignup)

        signIn.setOnClickListener {
            val userEmail = email.text.toString().trim()
            val userPass = password.text.toString().trim()

            if (userEmail.isEmpty() || userPass.isEmpty()) {
                Toast.makeText(this, "Please enter email & password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Signed in successfully", Toast.LENGTH_SHORT).show()

                // Intent to navigate to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Optional: Closes Login page so back button doesn't return here
            }
        }

        google.setOnClickListener {
            Toast.makeText(this, "Google Sign-In clicked", Toast.LENGTH_SHORT).show()
        }

        apple.setOnClickListener {
            Toast.makeText(this, "Apple Sign-In clicked", Toast.LENGTH_SHORT).show()
        }

        signup.setOnClickListener {
            Toast.makeText(this, "Sign Up clicked", Toast.LENGTH_SHORT).show()
        }
    }
}