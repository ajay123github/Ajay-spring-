package com.android.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DailyPanchangam : AppCompatActivity() {

    private lateinit var dbHelper:DatabaseHelper
    private var dateFormate=SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    private var currentDate= java.util.Date()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_daily_panchangam)


        var leftarrow=findViewById<ImageView>(R.id.leftarrow)

        var rightarrow=findViewById<ImageView>(R.id.rightarrow)
        dbHelper=DatabaseHelper(this)

        displayDateAndData(currentDate)

        leftarrow?.setOnClickListener(View.OnClickListener {
            val previousDate=Calendar.getInstance().apply {
                time=currentDate
                add(Calendar.DAY_OF_YEAR,-1)
            }.time

            if (isDateAvailableInDataBase(previousDate)){
                currentDate=previousDate
                displayDateAndData(currentDate)
            }
        })



        rightarrow?.setOnClickListener(View.OnClickListener {
            val nextDate=Calendar.getInstance().apply {
                time=currentDate
                add(Calendar.DAY_OF_YEAR,1)
            }.time

            if (isDateAvailableInDataBase(nextDate)){
                currentDate=nextDate
                displayDateAndData(currentDate)
            }
        })


    }

    private fun displayDateAndData(date: java.util.Date){
            val dateString=dateFormate.format(date)
        var tvdate=findViewById<TextView>(R.id.date)
        tvdate.text=dateString

       val cursor= dbHelper.getDataByDate(dateString)
        if (cursor!=null && cursor.moveToFirst()){
            var month=findViewById<TextView>(R.id.month)
            month.text=cursor.getString(1)
            var day=findViewById<TextView>(R.id.day)
            day.text=cursor.getString(2)
            var maasam=findViewById<TextView>(R.id.maasam)
            maasam.text=cursor.getString(3)
            var ruthuvu=findViewById<TextView>(R.id.ruthuvu)
            ruthuvu.text=cursor.getString(4)
            var yanam=findViewById<TextView>(R.id.yanam)
            yanam.text=cursor.getString(5)
            var suryodhayam=findViewById<TextView>(R.id.suryodhayam)
            suryodhayam.text=cursor.getString(6)
            var suryasthamayam=findViewById<TextView>(R.id.suryasthamayam)
            suryasthamayam.text=cursor.getString(7)
            var thidhi=findViewById<TextView>(R.id.thidhi)
            thidhi.text=cursor.getString(8)
            var nakshatram=findViewById<TextView>(R.id.nakshatram)
            nakshatram.text=cursor.getString(9)
            var yogam=findViewById<TextView>(R.id.yogam)
            yogam.text=cursor.getString(10)
            var karanam=findViewById<TextView>(R.id.karanam)
            karanam.text=cursor.getString(11)
            var goodtime=findViewById<TextView>(R.id.goodtime)
            goodtime.text=cursor.getString(12)
            var badtime=findViewById<TextView>(R.id.badtime)
            badtime.text=cursor.getString(13)
            var rahukalam=findViewById<TextView>(R.id.rahukalam)
            rahukalam.text=cursor.getString(14)
            var yamagandam=findViewById<TextView>(R.id.yamagandam)
            yamagandam.text=cursor.getString(15)
            var varjam=findViewById<TextView>(R.id.varjam)
            varjam.text=cursor.getString(16)
            var amruthatimings=findViewById<TextView>(R.id.amruthatimings)
            amruthatimings.text=cursor.getString(17)


        }else {
            var month=findViewById<TextView>(R.id.month)
            month.text="No Data Available"
            var day=findViewById<TextView>(R.id.day)
            day.text="No Data Available"
            var maasam=findViewById<TextView>(R.id.maasam)
            maasam.text="No Data Available"
            var ruthuvu=findViewById<TextView>(R.id.ruthuvu)
            ruthuvu.text="No Data Available"
            var yanam=findViewById<TextView>(R.id.yanam)
            yanam.text="No Data Available"
            var suryodhayam=findViewById<TextView>(R.id.suryodhayam)
            suryodhayam.text="No Data Available"
            var suryasthamayam=findViewById<TextView>(R.id.suryasthamayam)
            suryasthamayam.text="No Data Available"
            var thidhi=findViewById<TextView>(R.id.thidhi)
            thidhi.text="No Data Available"
            var nakshatram=findViewById<TextView>(R.id.nakshatram)
            nakshatram.text="No Data Available"
            var yogam=findViewById<TextView>(R.id.yogam)
            yogam.text="No Data Available"
            var karanam=findViewById<TextView>(R.id.karanam)
            karanam.text="No Data Available"
            var goodtime=findViewById<TextView>(R.id.goodtime)
            goodtime.text="No Data Available"
            var badtime=findViewById<TextView>(R.id.badtime)
            badtime.text="No Data Available"
            var rahukalam=findViewById<TextView>(R.id.rahukalam)
            rahukalam.text="No Data Available"
            var yamagandam=findViewById<TextView>(R.id.yamagandam)
            yamagandam.text="No Data Available"
            var varjam=findViewById<TextView>(R.id.amruthatimings)
            varjam.text="No Data Available"
        }

    }

    private fun isDateAvailableInDataBase(date: java.util.Date):Boolean{
        val dateString=dateFormate.format(date)
        val cursor=dbHelper.getDataByDate(dateString)
        val isAvailable=cursor!=null && cursor.count>0
        cursor?.close()
        return isAvailable
    }
}