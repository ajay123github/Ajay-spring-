package com.android.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, 1
) {

    companion object {
        private const val DATABASE_NAME = "telugu_calendar.db"
        private const val TABLE_NAME = "calender_details"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_MONTH = "monthName"
        private const val COLUMN_DAY = "dayName"
        private const val COLUMN_MAASAM = "maasam"
        private const val COLUMN_RUTHUVU = "ruthuvu"
        private const val COLUMN_YANAM = "yanam"
        private const val COLUMN_SURYODHAYAM = "suryodayam"
        private const val COLUMN_SURYASTHAMAYAM = "suryasthamayam"
        private const val COLUMN_THIDI = "thidi"
        private const val COLUMN_NAKSHATRAM = "nakshatram"
        private const val COLUMN_YOGAM = "yogam"
        private const val COLUMN_KARANAM = "karanam"
        private const val COLUMN_GOODTIME = "goodtime"
        private const val COLUMN_BADTIME = "badtime"
        private const val COLUMN_RAHUKALAM = "rahukalam"
        private const val COLUMN_YAMAGANDAM = "yamagandam"
        private const val COLUMN_VARJAM = "varjam"
        private const val COLUMN_AMRUTHATIMINGS = "amruthatimings"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_DATE TEXT PRIMARY KEY,
                $COLUMN_MONTH TEXT,
                $COLUMN_DAY TEXT,
                $COLUMN_MAASAM TEXT,
                $COLUMN_RUTHUVU TEXT,
                $COLUMN_YANAM TEXT,
                $COLUMN_SURYODHAYAM TEXT,
                $COLUMN_SURYASTHAMAYAM TEXT,
                $COLUMN_THIDI TEXT,
                $COLUMN_NAKSHATRAM TEXT,
                $COLUMN_YOGAM TEXT,
                $COLUMN_KARANAM TEXT,
                $COLUMN_GOODTIME TEXT,
                $COLUMN_BADTIME TEXT,
                $COLUMN_RAHUKALAM TEXT,
                $COLUMN_YAMAGANDAM TEXT,
                $COLUMN_VARJAM TEXT,
                $COLUMN_AMRUTHATIMINGS TEXT
            )
        """
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(
        date: String, month: String, day: String, maasam: String, ruthuvu: String, yanam: String,
        suryodhayam: String, suryasthamayam: String, thidi: String, nakshatram: String,
        yogam: String, karanam: String, goodtime: String, badtime: String, rahukalam: String,
        yamagandam: String, varjam: String, amruthatimings: String
    ): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_DATE, date)
            put(COLUMN_MONTH, month)
            put(COLUMN_DAY, day)
            put(COLUMN_MAASAM, maasam)
            put(COLUMN_RUTHUVU, ruthuvu)
            put(COLUMN_YANAM, yanam)
            put(COLUMN_SURYODHAYAM, suryodhayam)
            put(COLUMN_SURYASTHAMAYAM, suryasthamayam)
            put(COLUMN_THIDI, thidi)
            put(COLUMN_NAKSHATRAM, nakshatram)
            put(COLUMN_YOGAM, yogam)
            put(COLUMN_KARANAM, karanam)
            put(COLUMN_GOODTIME, goodtime)
            put(COLUMN_BADTIME, badtime)
            put(COLUMN_RAHUKALAM, rahukalam)
            put(COLUMN_YAMAGANDAM, yamagandam)
            put(COLUMN_VARJAM, varjam)
            put(COLUMN_AMRUTHATIMINGS, amruthatimings)
        }

        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close() // Close database after the operation
        return result != -1L
    }

    fun getDataByDate(date: String): Cursor{
        val db=this.readableDatabase
       return  db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_DATE=?"
        , arrayOf(date)
        )
    }
}
