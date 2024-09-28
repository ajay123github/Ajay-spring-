
package com.android.myapplication


import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.Fruits
import com.android.myapplication.FruitsAdapter
import com.android.myapplication.FruitsDataBaseHelper
import com.android.myapplication.R

//import com.android.notesapp.databinding.ActivityViewNoteBinding

class FruitsActivity : AppCompatActivity() {

    private lateinit var databaseHelper: FruitsDataBaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var fruitAdapter: FruitsAdapter
    private val fruitList = mutableListOf<Fruits>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_fruits)

        var leftarrow=findViewById<ImageView>(R.id.leftarrow)
        leftarrow?.setOnClickListener {
            var intent:Intent= Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

        databaseHelper = FruitsDataBaseHelper(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fruitAdapter = FruitsAdapter(this, fruitList)

        loadNotes()
  }

    private fun loadNotes() {
        val cursor: Cursor = databaseHelper.getAllFruits()
        if (cursor.count == 0) {
            // No data found
            cursor.close()
            return
        }

        while (cursor.moveToNext()) {
            val fruitsname = cursor.getString(0)
            val fruitsdescriptive = cursor.getString(1)
            fruitList.add(Fruits(fruitsname,fruitsdescriptive))
       }

        cursor.close()
        fruitAdapter.notifyDataSetChanged()
        recyclerView.adapter = fruitAdapter
    }

    override fun onResume() {
        super.onResume()
        fruitList.clear()
        loadNotes()
   }


}


