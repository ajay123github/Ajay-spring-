package com.android.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ServicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_services)

       var leftarrow= findViewById<ImageView>(R.id.leftarrow)
        leftarrow?.setOnClickListener {
            var intent:Intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
       }
    }
