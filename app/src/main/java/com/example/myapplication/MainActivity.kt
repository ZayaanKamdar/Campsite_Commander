package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val itemNames = arrayOf("Tent", "Marshmallows", "Flashlight")
    private val categories = arrayOf("Shelter", "Food", "Safety")
    private val quantities = intArrayOf(1, 3, 2)
    private val comments = arrayOf("4-person waterproof", "For S'mores", "Check batteries")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTotalItems = findViewById<TextView>(R.id.txtTotalItems)
        val btnAddGear = findViewById<Button>(R.id.btnAddGear)
        val btnViewGear = findViewById<Button>(R.id.btnViewGear)

        var totalItems = quantities.sum()
        txtTotalItems.text = "Total Items Packed: $totalItems"

        btnAddGear.setOnClickListener {
            totalItems += 1
            txtTotalItems.text = "Total Items Packed: $totalItems"
            Toast.makeText(this, "Gear Added", Toast.LENGTH_SHORT).show()
        }

        btnViewGear.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            // Passing data explicitly
            intent.putExtra("items", itemNames)
            intent.putExtra("categories", categories)
            intent.putExtra("quantities", quantities)
            intent.putExtra("comments", comments)
            startActivity(intent)
        }
    }
}