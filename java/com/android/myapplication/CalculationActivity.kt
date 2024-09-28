package com.android.myapplication

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_counter)

        var leftarrow=findViewById<ImageView>(R.id.leftarrow)
        leftarrow?.setOnClickListener {
            var intent: Intent =Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

        var twothousand=findViewById<TextView>(R.id.two)
        var twothousandText=findViewById<EditText>(R.id.et_currency_2000)
        var twothousandTotal=findViewById<TextView>(R.id.et_total_2000)

        var fivehundred=findViewById<TextView>(R.id.fivehundred)
        var fivehundredText=findViewById<EditText>(R.id.et_currency_500)
        var fivehundredTotal=findViewById<TextView>(R.id.et_total_500)

        var twohundred=findViewById<TextView>(R.id.twohundred)
        var twohundredText=findViewById<EditText>(R.id.et_currency_200)
        var twohundredTotal=findViewById<TextView>(R.id.et_total_200)

        var onehundred=findViewById<TextView>(R.id.one)
        var onehundredText=findViewById<EditText>(R.id.et_currency_100)
        var onehundredTotal=findViewById<TextView>(R.id.et_total_100)

        var fifty=findViewById<TextView>(R.id.fifty)
        var fiftyText=findViewById<EditText>(R.id.et_currency_50)
        var fiftyTotal=findViewById<TextView>(R.id.et_total_50)

        var twenty=findViewById<TextView>(R.id.twenty)
        var twentyText=findViewById<EditText>(R.id.et_currency_20)
        var twentyTotal=findViewById<TextView>(R.id.et_total_20)

        var ten=findViewById<TextView>(R.id.ten)
        var tenText=findViewById<EditText>(R.id.et_currency_10)
        var tenTotal=findViewById<TextView>(R.id.et_total_10)

        var five=findViewById<TextView>(R.id.five)
        var fiveText=findViewById<EditText>(R.id.et_currency_5)
        var fiveTotal=findViewById<TextView>(R.id.et_total_5)

        var tencoin=findViewById<TextView>(R.id.cten)
        var tencoinText=findViewById<EditText>(R.id.et_coin_10)
        var tencoinTotal=findViewById<TextView>(R.id.et_totalcoin_10)

        var fivecoin=findViewById<TextView>(R.id.fivecoin)
        var fivecoinText=findViewById<EditText>(R.id.et_coins_5)
        var fivecoinTotal=findViewById<TextView>(R.id.et_totalcoin_5)

        var twocoin=findViewById<TextView>(R.id.twocoin)
        var twocoinText=findViewById<EditText>(R.id.et_coin_2)
        var twocoinTotal=findViewById<TextView>(R.id.et_totalcoin_2)

        var onecoin=findViewById<TextView>(R.id.onecoin)
        var onecoinText=findViewById<EditText>(R.id.et_coin_1)
        var onecoinTotal=findViewById<TextView>(R.id.et_totalcoin_1)

        var totalamount=findViewById<TextView>(R.id.totalamountequal)
        var totalnotes=findViewById<TextView>(R.id.totalnotesequal)
        var totalcoins=findViewById<TextView>(R.id.totalcoinsequal)

        var calculate=findViewById<Button>(R.id.calculate)
        var clear=findViewById<Button>(R.id.back)

        calculate?.setOnClickListener {
            val result2=twothousand.text.toString().toDoubleOrNull()?:0.0
            val result2Text= twothousandText.text.toString().toDoubleOrNull()?:0.0
            val result2Total=result2*result2Text
            twothousandTotal.text=result2Total.toString()

            val result500=fivehundred.text.toString().toDoubleOrNull()?:0.0
            val result500Text=fivehundredText.text.toString().toDoubleOrNull()?:0.0
            val result500Total=result500*result500Text
            fivehundredTotal.text=result500Total.toString()

            val result200=twohundred.text.toString().toDoubleOrNull()?:0.0
            val result200Text=twohundredText.text.toString().toDoubleOrNull()?:0.0
            val result200Total=result200*result200Text
            twohundredTotal.text=result200Total.toString()

            val result100=onehundred.text.toString().toDoubleOrNull()?:0.0
            val result100Text=onehundredText.text.toString().toDoubleOrNull()?:0.0
            val result100Total=result100*result100Text
            onehundredTotal.text=result100Total.toString()

            val result50=fifty.text.toString().toDoubleOrNull()?:0.0
            val result50Text=fiftyText.text.toString().toDoubleOrNull()?:0.0
            val result50Total=result50*result50Text
            fiftyTotal.text=result50Total.toString()

            val result20=twenty.text.toString().toDoubleOrNull()?:0.0
            val result20Text=twentyText.text.toString().toDoubleOrNull()?:0.0
            val result20Total=result20*result20Text
            twentyTotal.text=result20Total.toString()

            val result10=ten.text.toString().toDoubleOrNull()?:0.0
            val result10Text=tenText.text.toString().toDoubleOrNull()?:0.0
            val result10Total=result10*result10Text
            tenTotal.text=result10Total.toString()

            val result5=five.text.toString().toDoubleOrNull()?:0.0
            val result5Text=fiveText.text.toString().toDoubleOrNull()?:0.0
            val result5Total=result5*result5Text
            fiveTotal.text=result5Total.toString()

            val result10c=tencoin.text.toString().toDoubleOrNull()?:0.0
            val result10cText=tencoinText.text.toString().toDoubleOrNull()?:0.0
            val result10cTotal=result10c*result10cText
            tencoinTotal.text=result10cTotal.toString()

            val result5c=fivecoin.text.toString().toDoubleOrNull()?:0.0
            val result5cText=fivecoinText.text.toString().toDoubleOrNull()?:0.0
            val result5cTotal=result5c*result5cText
            fivecoinTotal.text=result5cTotal.toString()

            val result2c=twocoin.text.toString().toDoubleOrNull()?:0.0
            val result2cText=twocoinText.text.toString().toDoubleOrNull()?:0.0
            val result2cTotal=result2c*result2cText
            twocoinTotal.text=result2cTotal.toString()

            val result1c=onecoin.text.toString().toDoubleOrNull()?:0.0
            val result1cText=onecoinText.text.toString().toDoubleOrNull()?:0.0
            val result1cTotal=result1c*result1cText
            onecoinTotal.text=result1cTotal.toString()


            val resultamount=result2Total+result500Total+result200Total+result100Total
            +result50Total+result20Total+result10Total+result10cTotal+result5cTotal
            +result2cTotal+result1cTotal
            val resultnotes=result2Text+result500Text+result200Text+result100Text+result50Text+result20Text
            +result10Text+result5Text

            val resultcoins=result10cText+result5cText+result2cText+result1cText

            totalamount.text=resultamount.toString()
            totalnotes.text=resultnotes.toString()
            totalcoins.text=resultcoins.toString()
        }

        clear?.setOnClickListener {
            twothousandText.text.clear()
            twothousandTotal.text="0"
            fivehundredText.text.clear()
            fivehundredTotal.text="0"
            twohundredText.text.clear()
            twohundredTotal.text=""
            onehundredText.text.clear()
            onehundredTotal.text="0"
            fiftyText.text.clear()
            fiftyTotal.text="0"
            twentyText.text.clear()
            twentyTotal.text="0"
            tenText.text.clear()
            tenTotal.text="0"
            tencoinText.text.clear()
            tencoinTotal.text="0"
            fivecoinText.text.clear()
            fivecoinTotal.text="0"
            twocoinText.text.clear()
            twocoinTotal.text="0"
            onecoinText.text.clear()
            onecoinTotal.text="0"
            totalamount.text="0"
            totalnotes.text="0"
            totalcoins.text="0"
        }

    }
}