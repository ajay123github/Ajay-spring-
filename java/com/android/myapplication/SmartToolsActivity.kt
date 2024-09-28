package com.android.myapplication

import CashCounterActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SmartToolsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_smart_tools)

        var leftarrow=findViewById<ImageView>(R.id.leftarrow)

        leftarrow?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        })

        var cashcountercard=findViewById<CardView>(R.id.cashcountercard)
        var countercard=findViewById<CardView>(R.id.countercard)
        var computershortcutscard=findViewById<CardView>(R.id.computershortcutscard)

        cashcountercard?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,CalculationActivity::class.java)
            startActivity(intent)
        })

        countercard?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,CounterActivity::class.java)
            startActivity(intent)
        })

        computershortcutscard?.setOnClickListener {
            var intent:Intent=Intent(this,ComputerShortCutsCardActivity::class.java)
            startActivity(intent)
        }
    }
}