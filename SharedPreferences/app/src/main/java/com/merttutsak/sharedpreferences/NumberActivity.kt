package com.merttutsak.sharedpreferences

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        var number: Int? = intent.getIntExtra("number", 0);

        textView_number.text = number.toString()

        button_back.setOnClickListener { onBackPressed() }
    }
}
