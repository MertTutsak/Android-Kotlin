package com.merttutsak.sharedpreferences

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = SharedPreferencesHelper(this)


        button_belirle.setOnClickListener {
            shared.setNumber(shared.getNumber() + 1)

        }

        button_sil.setOnClickListener {
            if (shared.getNumber() > 0) {
                shared.setNumber(shared.getNumber() - 1)
            } else {
                Toast.makeText(this, "Sayı 0'dan küçük olamaz !", Toast.LENGTH_SHORT).show();
            }
        }

        button_sayıyı_gör.setOnClickListener {
            val intent = Intent(applicationContext, NumberActivity::class.java)
            intent.putExtra("number", shared.getNumber())
            startActivity(intent)
        }
    }
}
