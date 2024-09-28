package com.android.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DinaphalaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinaphala)
            var mesham=findViewById<CardView>(R.id.meshamcard)
        var ox=findViewById<CardView>(R.id.oxcard)
        var mithunam=findViewById<CardView>(R.id.mithunamcard)
        var karkatakam=findViewById<CardView>(R.id.karkatakamcard)
        var lion=findViewById<CardView>(R.id.lioncard)
        var kanya=findViewById<CardView>(R.id.kanyacard)
        var thula=findViewById<CardView>(R.id.thulacard)
        var ant=findViewById<CardView>(R.id.antcard)
        var villu=findViewById<CardView>(R.id.villucard)
        var makaram=findViewById<CardView>(R.id.makaramcard)
        var kumbam=findViewById<CardView>(R.id.kumbamcard)
        var meenam=findViewById<CardView>(R.id.meenamcard)

        mesham?.setOnClickListener(View.OnClickListener {

        })
    }
}