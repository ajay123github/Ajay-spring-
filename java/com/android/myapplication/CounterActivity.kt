package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CounterActivity : AppCompatActivity() {
    private var count=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_counter)
        var leftarrow=findViewById<ImageView>(R.id.leftarrow)
        var btnIncrease=findViewById<Button>(R.id.btnIncrease)
        var btnDecrease=findViewById<Button>(R.id.btnDecrease)
        var btnreset=findViewById<Button>(R.id.btnReset)
        var counter=findViewById<TextView>(R.id.tvCounter)

        leftarrow?.setOnClickListener {
            var intent:Intent=Intent(this,SmartToolsActivity::class.java)
            startActivity(intent)
        }

        btnIncrease?.setOnClickListener {
            count++
            counter.text=count.toString()
        }

        btnDecrease?.setOnClickListener(View.OnClickListener {

                count--
                counter.text=count.toString()

        })

        btnreset?.setOnClickListener {
            count=0
            counter.text=count.toString()
        }
    }
}

