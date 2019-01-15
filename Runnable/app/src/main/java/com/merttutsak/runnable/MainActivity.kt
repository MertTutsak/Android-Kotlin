package com.merttutsak.runnable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number: Int = 0
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start.setOnClickListener {
            number = 0

            runnable = object : Runnable {
                override fun run() {
                    textView.text = number.toString()
                    number++
                    handler.postDelayed(this, 1000)
                }
            }

            handler.post(runnable)
        }

        button_reset.setOnClickListener {
            handler.removeCallbacks(runnable)
            number = 0

            textView.text = number.toString()
        }
    }
}
