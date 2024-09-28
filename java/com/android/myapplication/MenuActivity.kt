package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MenuActivity : AppCompatActivity() {

    private lateinit var fragmentcontainer: FrameLayout
    private lateinit var homeimage: ImageView
    private lateinit var servicesimage: ImageView
    private lateinit var smarttoolsimage: ImageView
    private lateinit var settingsimage: ImageView

    private lateinit var cardView: CardView
    private lateinit var cardlayout: LinearLayout
    private lateinit var image: ImageView
    private lateinit var descriptive: TextView

    private var cardcontentlist= listOf(
        CardContent(
            images = R.drawable.kubera,
            descriptives = "ఈ కుబేర బొమ్మను కొనండి మీ ఇంట్లో సుఖాలే\n" +
                    "\n" +
                    "కేవలం రూ.50/-\n" +
                    "మాత్రమే స్వరపదండి"
        ),

        CardContent(
            images = R.drawable.vinayaka,
            descriptives = "ఇంట్లో ప్రశాంతమైన పూజకు ఈ వినాయకుని బొమ్మ\n" +
                    "\n" +
                    "కేవలం రూ.100/-\n" +
                    "మాత్రమే స్వరపదండి"
        ),

        CardContent(
            images = R.drawable.lakshmidevi,
            descriptives = "ఇంట్లో సిరుల జల్లు కు ఈ లక్ష్మీదేవి బొమ్మ\n" +
                    "\n" +
                    "కేవలం రూ.50/-\n" +
                    "మాత్రమే స్వరపదండి"
        )

    )

    private var currentIndex=0
    private val cardChangeInterval:Long=2000

    private val handler= Handler(Looper.getMainLooper())
    private val runnable=object:Runnable{
        override fun run() {
            updateCardContent(currentIndex)
            currentIndex=(currentIndex+1)%cardcontentlist.size
            handler.postDelayed(this,cardChangeInterval)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        image=findViewById(R.id.image)
        descriptive=findViewById(R.id.descriptive)

        startCardRotation()

        //Loading fragment by default in activity
        if (savedInstanceState==null){
            //Method to load fragment by default in activity
            loadFragment(HomeFragment())
        }


      // fragmentcontainer= findViewById(R.id.fragmentcontainer)
        homeimage=findViewById(R.id.homeimage)
        homeimage?.setOnClickListener(View.OnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentcontainer,HomeFragment())
                .commit()
        })

       settingsimage= findViewById(R.id.settingsimage)
        settingsimage?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        })

       smarttoolsimage= findViewById(R.id.smarttoolsimage)
        smarttoolsimage?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,SmartToolsActivity::class.java)
            startActivity(intent)
        })

        servicesimage=findViewById(R.id.servicesimage)
        servicesimage?.setOnClickListener {
            var intent:Intent=Intent(this,ServicesActivity::class.java)
            startActivity(intent)
        }

        }



    private fun loadFragment(homeFragment: HomeFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentcontainer,HomeFragment())
            .commit()
    }

    private fun startCardRotation() {
        handler.post(runnable)
    }

    private fun updateCardContent(index: Int) {
        val content=cardcontentlist[index]
        image.setImageResource(content.images)
        descriptive.text=content.descriptives

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    data class CardContent(var images:Int,var descriptives:String)
}
