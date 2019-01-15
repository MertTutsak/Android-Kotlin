package com.merttutsak.ilk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Integer
        var x: Int = 5;
        var y: Int = 4;
        //val => //Değişebilir sayılar.

        println("Integer  x * y = " + x * y);

        //Double && Float
        val pi: Double = 3.14;
        //val => Değişmeyen sayılar. Final/Const gibi

        println("Double  x * pi = " + x * pi);

        //String
        val name: String = "Mert"
        val surname: String = "Tutsak"
        println("String name + surname = " + name + " " + surname);

        //Boolean
        val isAlive: Boolean = true
        println("Boolean isAlive = " + isAlive);

        //Arrays
        val arrays = arrayOfNulls<String>(4);// 4 elemanlı bir dizi oluşturuldu.

        arrays[0] = "Murat";
        arrays[1] = "Ömer";
        arrays[2] = "Mert";
        arrays[3] = "Mesut";

        println("Arrays arrays[2] = " + arrays[2]);

        val intArrays = arrayOf(10, 34, 56, 32, 54);//bir int dizisi oluşturuldu.

        println("Arrays intArrays size = " + intArrays.size);

        intArrays.set(2, 45); //2. indexde ki değeri değiştir
        println("Arrays intArrays[2] = " + intArrays[2]);

        //Lists
        val myList = ArrayList<String>();

        myList.add("Mert");
        myList.add("Mesut");
        myList.add("Berkcan");
        println("Lists myMusician = " + myList);
        myList.add(1, "Anıl");
        println("Lists myList[1] changed = " + myList.get(1));

        //Set
        val mySet = HashSet<String>();
        //Arrayden farkı aynı elemanı birden çok kez aynı listenin içine koyamazsınız
        mySet.add("Mert");
        mySet.add("Mesut");

        println("Set mySet = " + mySet);

        //Map
        val myMap = HashMap<String, String>();

        myMap.put("name", "Mert");
        myMap.put("surname", "Tutsak");

        println("Map myMap\nmyMap[\"name\"] = " + myMap["name"] + " myMap[\"surname\"] => " + myMap["surname"]);

        //Operators
        var sayi1 = 5;
        println("Operators ++sayi1 =" + ++sayi1);//arttırdıktan sonra atar.
        println("Operators sayi1++ =" + sayi1++);//Atadıktan sonra arttır.
        var sayi2 = 5;
        println("Operators sayi2 =" + sayi2);
        println("Operators sayi2-- =" + sayi2--);//arttırdıktan sonra atar.
        println("Operators --sayi2 =" + --sayi2);//arttırdıktan sonra atar.


        println("Operators sayi1 > sayi2 = " + (sayi1 > sayi2));
        println("Operators sayi1 >= sayi2 = " + (sayi1 >= sayi2));
        println("Operators sayi1 < sayi2 = " + (sayi1 > sayi2));
        println("Operators sayi1 <= sayi2 = " + (sayi1 <= sayi2));
        println("Operators sayi1 == sayi2 = " + (sayi1 == sayi2));
        println("sayi1 =" + sayi1 + " sayi2 =" + sayi2);
        println("Operators (sayi1 == 7 && sayi2 == 5) = " + ((sayi1 == 7 && sayi2 == 5)));
        println("Operators (sayi1 == 7 || sayi2 == 5) = " + ((sayi1 == 7 || sayi2 == 5)));

        //Switch
        val day = 1;
        var dayString = "";

        when (day) {
            1 -> dayString = "Monday"
            2 -> dayString = "Tuesday"
            3 -> dayString = "Wednesday"
            4 -> dayString = "Thursday"
            5 -> dayString = "Friday"
            6 -> dayString = "Saturday"
            7 -> dayString = "Sunday"
            else -> dayString = "Day couldn't find"
        }

        println("Switch dayString = " + dayString);

        //For
        val myNumbers = arrayOf(3, 4, 5, 7);

        println("Foreach =>");

        for (number in myNumbers) {//Değer döndürür
            println("number = " + number);
        }

        println("Foreach by indices =>");

        for (index in myNumbers.indices) {//İndex döndürür
            println("number(" + index + ") = " + myNumbers[index]);
        }

        println("Foreach from 1 to 3 =>");
        for (number in 1..3) {//1 ile 3 arasında ki sayıları getirir
            println("number = " + number);
        }

        //While
        var j = 4;
        println("While =>");
        while (j < 10) {// j 10'dan küçük olduğu sürece
            print("j = " + j);
            val x = j * 10;
            println(" (j*10 = x) x => " + x);
            j++;
        }
    }

}
