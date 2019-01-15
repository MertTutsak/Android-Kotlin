package com.merttutsak.timer

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timer = object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                textTimer.text = "0"
                button.isEnabled = true
                Toast.makeText(this@MainActivity, "FINISH !", Toast.LENGTH_LONG).show()
            }

            override fun onTick(millisUntilFinished: Long) {
                textTimer.text = ((millisUntilFinished / 1000) + 1).toString()
            }
        }

        button.setOnClickListener {
            button.isEnabled = false
            timer.start()
        }
    }
}
