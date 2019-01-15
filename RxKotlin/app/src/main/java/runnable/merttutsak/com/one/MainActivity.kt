package runnable.merttutsak.com.one

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchComponent.setOnClickListener {
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if (switchComponent.isChecked) {
                        normal()
                    } else {
                        RxKotlin()
                    }
                }
            }
        }
        RxKotlin()
    }

    fun RxKotlin() {
        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) = Unit

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) =
                    subscriber.onNext(s.toString())
            })
        }).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ text ->
                textView.text = "RxKotlin : " + text
            })
    }

    fun normal() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textView.text = "Normal : " + s
            }
        })
    }
}
