package com.example.luckynumberapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)
        val textV: TextView = findViewById(R.id.editTextTextPersonName)

        btn.setOnClickListener {
            if (textV.text.toString().isEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    "informe um nome no campo acima",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val intent = Intent(this, Activity2::class.java)
                intent.putExtra("name", textV.text.toString())
                startActivity(intent)
            }

        }
    }
}