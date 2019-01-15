package com.merttutsak.functionsandclasses

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Function =>")

        val test = Test()

        test.sum(6, 3)
        println("test (8 / 3) = " + test.div(8, 3));
    }
    fun makeSimpson(view: View) {

        val name = editTextName.text.toString()
        var age: Int? = null
        val job = editTextJob.text.toString()

        if (!editTextAge.text.toString().equals("")) {
            try {
                age = editTextAge.text.toString().toInt()
            }catch (e : Exception){
            }
        }

        val homer = Simpson(name, age, job);

        textSimpson.text = "Name = " + homer.name + " Age = " + homer.age + " Job = " + homer.job
    }

    class Test: Operations() {// Test Operations'dan kalıtım aldı
    }

    open class Operations(){
        fun sum(a: Int, b: Int) {
            println("sum " + a + " + " + b + " = " + (a + b));
        }

        fun div(a: Int, b: Int): Double {
            return (a / b).toDouble();
        }
    }

}
