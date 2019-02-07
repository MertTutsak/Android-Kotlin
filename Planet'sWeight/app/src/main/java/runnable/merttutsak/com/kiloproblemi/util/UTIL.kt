package runnable.merttutsak.com.kiloproblemi.util

class UTIL {
    companion object {
        var unit = 2.2045

        fun kiloToPound(pound: Double): Double = (pound / unit) // thing that returns is kilo

        fun poundToKilo(kilo: Double): Double = (kilo * unit) // thing that returns is pound
    }

}