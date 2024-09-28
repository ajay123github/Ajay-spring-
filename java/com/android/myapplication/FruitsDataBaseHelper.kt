package com.android.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FruitsDataBaseHelper(context: Context?) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, 1
) {

    companion object {
        private const val DATABASE_NAME = "fruitinfo.db"
        private const val TABLE_NAME = "fruits"
        private const val FRUITS_NAME = "name"
        private const val FRUITS_DESCRIPTIVE = "descriptive"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME(
            $FRUITS_NAME TEXT PRIMARY KEY,
            $FRUITS_DESCRIPTIVE TEXT 
            )
            """
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertFruits(name: String, descriptive: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(FRUITS_NAME, name)
            put(FRUITS_DESCRIPTIVE, descriptive)
        }
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    fun getAllFruits(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun deleteAllFruits(){
        val db=this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
        db.close()
    }
}
