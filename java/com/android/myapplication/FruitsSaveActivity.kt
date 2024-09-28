package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FruitsSaveActivity : AppCompatActivity() {
    private lateinit var fruitsdbHelper: FruitsDataBaseHelper
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_save)
        var leftarrow=findViewById<ImageView>(R.id.leftarrow)
        var name=findViewById<EditText>(R.id.fruitname)
        var fruitdescription=findViewById<EditText>(R.id.fruitdescriptive)
        var savefruit=findViewById<Button>(R.id.fruitssave)
        var back=findViewById<Button>(R.id.back)

        fruitsdbHelper=FruitsDataBaseHelper(this)
        leftarrow?.setOnClickListener {
            var intent:Intent=Intent(this, SettingsActivity::class.java
            )
            startActivity(intent)
        }

        back?.setOnClickListener {
            var intent:Intent=Intent(this, SettingsActivity::class.java
            )
            startActivity(intent)
        }


        savefruit?.setOnClickListener(View.OnClickListener {

            var nameText=name.text.toString()
            var fruitdescriptionText=fruitdescription.text.toString()
            if (nameText.isEmpty() || fruitdescriptionText.isEmpty()){
                Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show()

            }else {
                val isInserted=fruitsdbHelper.insertFruits(nameText,fruitdescriptionText)
                if (isInserted){
                    Toast.makeText(this,"data is saved Successfully",Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this,"data is not saved Successfully",Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}