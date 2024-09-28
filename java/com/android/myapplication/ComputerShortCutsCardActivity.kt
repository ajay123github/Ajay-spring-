package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ComputerShortCutsCardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_computer_short_cuts_card)
        var leftarrow=findViewById<ImageView>(R.id.leftarrow)
        leftarrow?.setOnClickListener {
            var intent:Intent= Intent(this,SmartToolsActivity::class.java)
            startActivity(intent)
        }
    }
}