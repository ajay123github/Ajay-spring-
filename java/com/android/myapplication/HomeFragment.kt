package com.android.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
//import com.android.kotlindatabase.FruitsActivity


class HomeFragment : Fragment() {
private lateinit var panchangamcard:CardView
private lateinit var panchangamicon:ImageView
private lateinit var panchangamtext:TextView

    private lateinit var panchangammontcard:CardView
    private lateinit var panchangammonthicon:ImageView
    private lateinit var panchangammonthtext:TextView

    private lateinit var rasipalamcard:CardView
    private lateinit var rasipalamicon:ImageView
    private lateinit var rasipalamtext:TextView

    private lateinit var pandugacard:CardView
    private lateinit var pandugaicon:ImageView
    private lateinit var pandugatext:TextView

    private lateinit var pellicard:CardView
    private lateinit var pelliicon:ImageView
    private lateinit var pellitext:TextView

    private lateinit var poojacard:CardView
    private lateinit var poojaicon:ImageView
    private lateinit var poojatext:TextView

    private lateinit var computerrasiimage:ImageView
    private lateinit var computerrasitext:TextView

    private lateinit var homamserviceimage:ImageView
    private lateinit var homamservicetext:TextView

    private lateinit var janmapathrikaimage:ImageView
    private lateinit var janmapathrikatext:TextView

    private lateinit var jobimage:ImageView
    private lateinit var jobtext:TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.panchangam,container,false)
         val rasipalamcard= view.findViewById<CardView>(R.id.rasipalamcard)
        rasipalamcard?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(activity,RasipalaluActivity::class.java)
            startActivity(intent)
        })

        val panchangamcard =view.findViewById<CardView>(R.id.panchangamcard)
        panchangamcard?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(activity,DailyPanchangam::class.java)
            startActivity(intent)
        })

        val fruits=view.findViewById<ImageView>(R.id.fruitsimage)
        fruits?.setOnClickListener(View.OnClickListener {
            var intent:Intent=Intent(activity, FruitsActivity::class.java)
            startActivity(intent)
        })

        val pellicard=view.findViewById<CardView>(R.id.pellicard)
        pellicard?.setOnClickListener {
            var intent:Intent=Intent(activity,PelliActivity::class.java)
            startActivity(intent)
        }
        return view
    }



}