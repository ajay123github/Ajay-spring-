package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import com.android.kotlindatabase.FruitsActivity

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        var save=findViewById<TextView>(R.id.save)
        var retriew=findViewById<TextView>(R.id.retriew)
        var update=findViewById<TextView>(R.id.update)
        var delete=findViewById<TextView>(R.id.delete)

        var fruitsave=findViewById<TextView>(R.id.fruitsave)
        var fruitretriew=findViewById<TextView>(R.id.fruitretriew)
        var fruitupdate=findViewById<TextView>(R.id.fruitupdate)
        var fruitdelete=findViewById<TextView>(R.id.fruitdelete)

        save?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,SaveActivity::class.java)
            startActivity(intent)
        })

        fruitsave?.setOnClickListener {
            var intent:Intent=Intent(this,FruitsSaveActivity::class.java)
            startActivity(intent)
        }

        retriew?.setOnClickListener {
            var intent:Intent=Intent(this,DailyPanchangam::class.java)
            startActivity(intent)
        }

        fruitretriew?.setOnClickListener {
            var intent:Intent=Intent(this, FruitsActivity::class.java)
            startActivity(intent)
        }

//        fruitdelete?.setOnClickListener {
//            var fruitdb:FruitsDataBaseHelper=FruitsDataBaseHelper(this)
//            var isDeleted=fruitdb.deleteAllFruits()
//
//        }


        }
    }
