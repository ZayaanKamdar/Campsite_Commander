package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Load the layout
        setContentView(R.layout.activity_detailedview)

        // Show a popup to confirm the activity is starting
        Toast.makeText(this, "Displaying Inventory...", Toast.LENGTH_SHORT).show()

        val txtDisplay = findViewById<TextView>(R.id.txtDetailedInventoryDisplay)
        val btnBack = findViewById<Button>(R.id.btnBackToMain)

        // Explicitly set text color to White to ensure it is visible on the dark background
        txtDisplay.setTextColor(Color.WHITE)

        // Retrieve the data passed from MainActivity
        val items = intent.getStringArrayExtra("items") ?: arrayOf()
        val categories = intent.getStringArrayExtra("categories") ?: arrayOf()
        val quantities = intent.getIntArrayExtra("quantities") ?: intArrayOf()
        val comments = intent.getStringArrayExtra("comments") ?: arrayOf()

        val displayBuilder = StringBuilder()
        displayBuilder.append("CAMPSITE GEAR INVENTORY\n")
        displayBuilder.append("========================\n\n")

        if (items.isEmpty()) {
            displayBuilder.append("No gear items found. Go back and add some!")
        } else {
            for (i in items.indices) {
                val cat = if (i < categories.size) categories[i] else "N/A"
                val qty = if (i < quantities.size) quantities[i].toString() else "0"
                val note = if (i < comments.size) comments[i] else "N/A"

                displayBuilder.append("NAME: ${items[i]}\n")
                displayBuilder.append("CAT: $cat | QTY: $qty\n")
                displayBuilder.append("NOTES: $note\n")
                displayBuilder.append("------------------------\n\n")
            }
        }

        // Apply the text to the view
        txtDisplay.text = displayBuilder.toString()

        // Handle back button
        btnBack.setOnClickListener {
            finish()
        }
    }
}