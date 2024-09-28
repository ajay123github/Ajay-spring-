package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SaveActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_save)

        //Connecting SQLite to this Activity
        dbHelper= DatabaseHelper(this)

        var date=findViewById<EditText>(R.id.date)
        var month=findViewById<EditText>(R.id.month)
        var day=findViewById<EditText>(R.id.day)
        var maasam=findViewById<EditText>(R.id.maasam)
        var ruthuvu=findViewById<EditText>(R.id.ruthuvu)
        var yanam=findViewById<EditText>(R.id.yanam)
        var suryodhayam=findViewById<EditText>(R.id.suryodhayam)
        var suryasthamayam=findViewById<EditText>(R.id.suryasthamayam)
        var thidi=findViewById<EditText>(R.id.thidi)
        var nakshatram=findViewById<EditText>(R.id.nakshatram)
        var yogam=findViewById<EditText>(R.id.yogam)
        var karanam=findViewById<EditText>(R.id.karanam)
        var goodtime=findViewById<EditText>(R.id.goodtime)
        var badtime=findViewById<EditText>(R.id.badtime)
        var rahukalam=findViewById<EditText>(R.id.rahukalam)
        var yamagandam=findViewById<EditText>(R.id.yamagandam)
        var varjam=findViewById<EditText>(R.id.varjam)
        var amruthamtimings=findViewById<EditText>(R.id.amruthatimings)

        var save=findViewById<Button>(R.id.save)
        var back=findViewById<Button>(R.id.back)
        var leftarrow=findViewById<ImageView>(R.id.leftarrow)


        back?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        })

        leftarrow?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        })

        save?.setOnClickListener(View.OnClickListener {
            var dateText=date.text.toString()
            var monthText=month.text.toString()
            var dayText=day.text.toString()
            var maasamText=maasam.text.toString()
            var ruthuvuText=ruthuvu.text.toString()
            var yanamText=yanam.text.toString()
            var suryodhayamText=suryodhayam.text.toString()
            var suryasthamayamText=suryasthamayam.text.toString()
            var thidiText=thidi.text.toString()
            var nakshatramText=nakshatram.text.toString()
            var yogamText=yogam.text.toString()
            var karanamText=karanam.text.toString()
            var goodtimeText=goodtime.text.toString()
            var badtimeText=badtime.text.toString()
            var rahukalamText=rahukalam.text.toString()
            var yamagandamText=yamagandam.text.toString()
            var varjamText=varjam.text.toString()
            var amruthamtimingsText=amruthamtimings.text.toString()

            if (dateText.isEmpty() || monthText.isEmpty() || dayText.isEmpty() || maasamText.isEmpty()
                || ruthuvuText.isEmpty() || yanamText.isEmpty() || suryodhayamText.isEmpty()
                || suryasthamayamText.isEmpty() || thidiText.isEmpty() || nakshatramText.isEmpty()
                || yogamText.isEmpty() || karanamText.isEmpty() || goodtimeText.isEmpty()
                || badtimeText.isEmpty() || rahukalamText.isEmpty() || yamagandamText.isEmpty()
                || varjamText.isEmpty() || amruthamtimingsText.isEmpty()){

                Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show()

            }else{
                    val isInserted=dbHelper.insertData(dateText,monthText,dayText,maasamText,ruthuvuText,yanamText,suryodhayamText,
                        suryasthamayamText,thidiText,nakshatramText,yogamText,karanamText,goodtimeText,badtimeText
                    ,rahukalamText,yamagandamText,varjamText,amruthamtimingsText);
                if (isInserted){
                    Toast.makeText(this,"data is inserted Successfully", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"data is not inserted Successfully", Toast.LENGTH_SHORT).show()
                }
            }
        })
        
    }
}