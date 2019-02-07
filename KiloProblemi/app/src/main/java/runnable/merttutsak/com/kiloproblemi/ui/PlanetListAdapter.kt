package runnable.merttutsak.com.kiloproblemi.ui

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import runnable.merttutsak.com.kiloproblemi.R


class PlanetListAdapter(private val context: Activity, private var planets: ArrayList<Planet>) : BaseAdapter() {
    var weight: Double = 0.0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.item_listview, null, true)
        val background: Drawable = view.background
        background.alpha = 80

        val textPlanetName = view.findViewById<TextView>(R.id.textView_planet_name)

        val textWeight = view.findViewById<TextView>(R.id.textView_weight)

        textPlanetName.text = planets.get(position).name
        textWeight.text = String.format("%.2f", planets.get(position).unit * weight)

        return view
    }

    override fun getItem(position: Int): Any {
        return planets.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return planets.size
    }

}