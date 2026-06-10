package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailedview)

        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val items = intent.getStringArrayExtra("items")
        val categories = intent.getStringArrayExtra("categories")
        val quantities = intent.getIntArrayExtra("quantities")
        val comments = intent.getStringArrayExtra("comments")

        var gearList = ""

        if (items != null) {

            for (i in items.indices) {

                gearList +=
                    "Item: ${items[i]}\n" +
                            "Category: ${categories!![i]}\n" +
                            "Quantity: ${quantities!![i]}\n" +
                            "Notes: ${comments!![i]}\n\n"
            }
        }

        txtDisplay.text = gearList

        btnBack.setOnClickListener {
            finish()
        }
    }
}