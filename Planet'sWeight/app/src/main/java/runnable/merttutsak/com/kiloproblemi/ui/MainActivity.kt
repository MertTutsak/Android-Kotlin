package runnable.merttutsak.com.kiloproblemi.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_listview.*
import runnable.merttutsak.com.kiloproblemi.R
import runnable.merttutsak.com.kiloproblemi.util.UTIL
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    //List
    var adapter: PlanetListAdapter? = null

    //AdView
    var adView: AdView? = null

    //Locale Country
    var countryForForeign: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var country =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                this.getResources().configuration.locales.toLanguageTags()
            else
                this.getResources().getConfiguration().locale.getCountry()

        countryForForeign = country.contains("tr").not()

        editText_weight.hint = if(countryForForeign) "Weight as kilo!" else "Kilo cinsinden giriniz!"

        //AdMob
        MobileAds.initialize(this, resources.getString(R.string.app_admob_id))

        var interstitialAd = InterstitialAd(this)
        interstitialAd.adUnitId = resources.getString(R.string.interstitial_ad_unit_id)
        interstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                interstitialAd.show()
                Log.d(this@MainActivity.javaClass.simpleName, "Interstitial Ad Showed")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                Log.d(
                    this@MainActivity.javaClass.simpleName,
                    "Interstitial Ad Failed To Load, Error Code :" + errorCode
                )
            }

            override fun onAdClosed() {
                Log.d(this@MainActivity.javaClass.simpleName, "Interstitial Ad Closed")
            }
        }

        var planets: ArrayList<Planet> = ArrayList()

        planets.add(Planet(if (countryForForeign) "Mercury" else "Merkür", UTIL.kiloToPound(0.38)))
        planets.add(Planet(if (countryForForeign) "Venus" else "Merkür", UTIL.kiloToPound(0.91)))
        planets.add(Planet(if (countryForForeign) "Mars" else "Mars", UTIL.kiloToPound(0.38)))
        planets.add(Planet(if (countryForForeign) "Jupiter" else "Jüpiter", UTIL.kiloToPound(2.34)))
        planets.add(Planet(if (countryForForeign) "Saturn" else "Satürn", UTIL.kiloToPound(1.06)))
        planets.add(Planet(if (countryForForeign) "Uranus" else "Uranüs", UTIL.kiloToPound(0.92)))
        planets.add(Planet(if (countryForForeign) "Neptune" else "Neptün", UTIL.kiloToPound(1.19)))
        planets.add(Planet(if (countryForForeign) "Pluto" else "Plüton", UTIL.kiloToPound(0.06)))

        adapter = PlanetListAdapter(this, planets)

        imageButton_convert.setOnClickListener {
            if (editText_weight != null) {
                if (editText_weight.text != null) {
                    if (editText_weight.text.toString().trim() != "") {
                        adapter?.weight = java.lang.Double.parseDouble(editText_weight.text.toString())
                        adapter?.notifyDataSetChanged()

                        val random: Int = Random().nextInt(5)

                        Log.d(this@MainActivity.javaClass.simpleName, "Random Number :" + random);
                        if (random == 1 && isNetworkAvailable()) {
                            interstitialAd.loadAd(AdRequest.Builder().build())
                        }
                    } else {
                        Toast.makeText(this, if (countryForForeign) "Input your weight, please!" else "Lütfen, ağırlığınızı giriniz", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        if (isNetworkAvailable()) {
            adView_bottom.adListener = object : AdListener() {
                override fun onAdLoaded() {
                    Log.d(this@MainActivity.javaClass.simpleName, "Banner Ad Showed")
                }

                override fun onAdFailedToLoad(errorCode: Int) {
                    Log.d(
                        this@MainActivity.javaClass.simpleName,
                        "Banner Ad Failed To Load, Error Code :" + errorCode
                    )
                }

                override fun onAdClosed() {
                    Log.d(this@MainActivity.javaClass.simpleName, "Banner Ad Closed")
                }
            }
            adView_bottom.loadAd(AdRequest.Builder().build())
        }
        gridView.adapter = adapter
    }


    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
}
