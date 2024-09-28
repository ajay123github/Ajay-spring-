package com.android.myapplication

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
import com.android.myapplication.DinaphalaActivity

class RasipalaluActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_rasipalalu)
        var dinacard=findViewById<CardView>(R.id.dinacard)
        var varacard=findViewById<CardView>(R.id.varacard)
        var maasacard=findViewById<CardView>(R.id.maasacard)
        var yearcard=findViewById<CardView>(R.id.yearcard)
        var englishyearcard=findViewById<CardView>(R.id.englishyearcard)
        var rasihistorycard=findViewById<CardView>(R.id.rasihistorycard)
        var birthcard=findViewById<CardView>(R.id.birthcard)
        var starcard=findViewById<CardView>(R.id.starcard)
        var leftarrow=findViewById<ImageView>(R.id.leftarrow)

        leftarrow?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        })

        dinacard?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,DinaphalaActivity::class.java)
            startActivity(intent)
        })
    }
}