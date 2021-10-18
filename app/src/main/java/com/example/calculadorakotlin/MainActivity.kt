package com.example.calculadorakotlin

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Long.parseLong

class MainActivity : AppCompatActivity() {
    var datos=""
    var operacion=""
    var datos2=""
    var datos3: Long = 0
    var memoria=""
    var memoriaHex=""
    var operacionHex=""
    var datosHex=""
    var datosHex2=""
    var hexDec1: Long=0
    var hexDec2: Long=0
    //var x = convertBinaryToDecimal(bin)
   // var resBin = Integer.toBinaryString(bin.toInt())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val orientation=resources.configuration.orientation
        if(orientation==Configuration.ORIENTATION_PORTRAIT){
            calDec()
        }else{
            calHex()
            bA.setEnabled(true)
            bB.setEnabled(true);
            bC.setEnabled(true);
            bD.setEnabled(true);
            bE.setEnabled(true);
            bF.setEnabled(true);
        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bin -> {
                var bin = datos3.toString()
                var resBin = Integer.toBinaryString(bin.toInt())
                resulText.setText(resBin.toString())
                true
            }
            R.id.deci -> {
                resulText.setText(datos3.toString())
                true
            }
            R.id.hexa -> {
                var e = datos3.toString()
                var r = Integer.toHexString(e.toInt())
                resulText.setText(r.toString().toUpperCase())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun calDec() {
        b1.setOnClickListener() {
            datos += "1"
            tv_Operador.setText(datos)
        }
        b2.setOnClickListener() {
            datos += "2"
            tv_Operador.setText(datos)
        }
        b3.setOnClickListener() {
            datos += "3"
            tv_Operador.setText(datos)
        }
        b4.setOnClickListener() {
            datos += "4"
            tv_Operador.setText(datos)
        }
        b5.setOnClickListener() {
            datos += "5"
            tv_Operador.setText(datos)
        }
        b5.setOnClickListener() {
            datos += "5"
            tv_Operador.setText(datos)
        }
        b6.setOnClickListener() {
            datos += "6"
            tv_Operador.setText(datos)
        }
        b7.setOnClickListener() {
            datos += "7"
            tv_Operador.setText(datos)
        }
        b8.setOnClickListener() {
            datos += "8"
            tv_Operador.setText(datos)
        }
        b9.setOnClickListener() {
            datos += "9"
            tv_Operador.setText(datos)
        }
        b0.setOnClickListener() {
            datos += 0;
            tv_Operador.setText(datos)
        }
        sum.setOnClickListener {
            datos2 = datos
            datos = ""
            tv_Operador.setText(datos2 + "+")
            operacion = "+"
        }
        res.setOnClickListener() {
            datos2 = datos
            datos = ""
            tv_Operador.setText(datos2 + "-")
            operacion = "-"
        }
        mult.setOnClickListener() {
            datos2 = datos
            datos = ""
            tv_Operador.setText(datos2 + "x")
            operacion = "x"
        }
        Div.setOnClickListener() {
            datos2 = datos
            datos = ""
            tv_Operador.setText(datos2 + "/")
            operacion = "/"
        }

        Coma.setOnClickListener() {
            datos += "."
        }
        Del.setOnClickListener() {
            if (tv_Operador.text.toString() == "") {
                datos = ""
                tv_Operador.setText(datos)
            } else {
                var datBorr = tv_Operador.text
                val ult = datBorr.length
                var newDat = datBorr.substring(0, ult - 1)
                datos = newDat
                tv_Operador.setText(datos)
            }
        }
        AC.setOnClickListener() {
            datos = ""
            datos2 = ""
            tv_Operador.setText(datos.toString())
        }
        igual.setOnClickListener(){
            tv_lastOperation.setText(datos2.toString()+operacion.toString()+datos.toString())
            if(datos2=="") datos2="0"
            when(operacion){
                "+" -> tv_Operador.setText((datos2.toDouble()+datos.toDouble()).toString());
                "-" -> tv_Operador.setText((datos2.toDouble()-datos.toDouble()).toString());
                "x" -> tv_Operador.setText((datos2.toDouble()*datos.toDouble()).toString());
                "/" -> tv_Operador.setText((datos2.toDouble()/datos.toDouble()).toString());
            }
            datos=tv_Operador.text.toString()

        }
    }
    fun calHex(){
        b0Hex.setOnClickListener(){
            datosHex+="0"
            resulText.setText(datosHex)
        }
        b1Hex.setOnClickListener(){
            datosHex+="1"
            resulText.setText(datosHex)

        }
        b2Hex.setOnClickListener(){
            datosHex+="2"
            resulText.setText(datosHex)
        }
        b3Hex.setOnClickListener(){
            datosHex+="3"
            resulText.setText(datosHex)
        }
        b4Hex.setOnClickListener(){
            datosHex+="4"
            resulText.setText(datosHex)
        }
        b5Hex.setOnClickListener(){
            datosHex+="5"
            resulText.setText(datosHex)
        }
        b6Hex.setOnClickListener(){
            datosHex+="6"
            resulText.setText(datosHex)
        }
        b7Hex.setOnClickListener(){
            datosHex+="7"
            resulText.setText(datosHex)
        }
        b8Hex.setOnClickListener(){
            datosHex+="8"
            resulText.setText(datosHex)
        }
        b9Hex.setOnClickListener(){
            datosHex+="9"
            resulText.setText(datosHex)
        }
        bA.setOnClickListener {
            datosHex+="A"
            resulText.setText(datosHex)
        }
        bB.setOnClickListener {
            datosHex+="B"
            resulText.setText(datosHex)
        }
        bC.setOnClickListener {
            datosHex+="C"
            resulText.setText(datosHex)
        }
        bD.setOnClickListener {
            datosHex+="D"
            resulText.setText(datosHex)
        }
        bE.setOnClickListener {
            datosHex+="E"
            resulText.setText(datosHex)
        }
        bF.setOnClickListener {
            datosHex+="F"
            resulText.setText(datosHex)
        }
        sumHex.setOnClickListener(){
            operacionHex="+"
            datosHex2=datosHex
            datosHex=""
            resulText.setText(datosHex2+"+")
        }
        resHex.setOnClickListener(){
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
            resulText.setText(datosHex2+"-")
        }
        mulHex.setOnClickListener(){
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
            resulText.setText(datosHex2+"x")
        }
        divHex.setOnClickListener() {
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
            resulText.setText(datosHex2+"/")
        }

        DelHex.setOnClickListener(){
            if(resulText.text.toString()==""){
                datosHex=""
                resulText.setText(datosHex)
            }else {
                var datBorrHex = resulText.text
                val ultHex = datBorrHex.length
                var newDatHex = datBorrHex.substring(0, ultHex - 1)
                datosHex = newDatHex
                resulText.setText(datosHex)
            }
        }
        ACHex.setOnClickListener(){
            datosHex=""
            datosHex2=""
            resulText.setText(datosHex)
        }
       igualHex.setOnClickListener(){
            if(datosHex2=="") datosHex2="0"
            try {
                execHex(hex2dec(datosHex2),hex2dec(datosHex))
            }catch (e: ArithmeticException){
                resulText.setText("No se puede dividir entre 0")
            }
        }
    }
    fun execHex(hex1: Long,hex2: Long){
        when(operacionHex){
            "+" -> datos3=(hex1+hex2)
            "-" -> datos3=(hex1-hex2)
            "x" -> datos3=(hex1*hex2)
            "/" -> datos3=(hex1/hex2)
        }
        var hexString=java.lang.Long.toHexString(datos3)
        resulText.setText(hexString.toUpperCase())
        datosHex= resulText.text.toString()
    }

    fun hex2dec(hex: String): Long {
        return parseLong(hex,16)
    }
}








