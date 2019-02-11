package com.io.sefu.rsolverfinalui;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Processing {

    HashMap<Integer, String> hashMap;
    Context context;

    Processing(Context context,HashMap<Integer,String> hashMap){
        this.context = context;
        this.hashMap = hashMap;
    }

    StringBuilder stringBuilder = new StringBuilder();

    public static <K extends Comparable, V extends Comparable> HashMap<K, V> sortByKeys(Map<K, V> map) {
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);

        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        HashMap<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (K key : keys) {
            sortedMap.put(key, map.get(key));
        }

        return sortedMap;
    }

    //  Validate if Entered colors are valid or not...
    boolean ValidString() {
        HashMap<Integer, String> sortedMap = sortByKeys(hashMap);

        //  Count Occurence of a color in map for validation...
        int OrangeCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#FFA500");
        int RedCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#FF0000");
        int WhiteCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#FFFFFF");
        int YellowCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#FFFF00");
        int BlueCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#0000FF");
        int GreenCount = Collections.frequency(new ArrayList<String>(sortedMap.values()), "#008000");

        if (OrangeCount % 9 == 0 && RedCount % 9 == 0 && WhiteCount % 9 == 0 && YellowCount % 9 == 0 && BlueCount % 9 == 0 && GreenCount % 9 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
    *   Orange --> U
    *   Green --> L
    *   White --> F
    *   Red --> D
    *   Blue --> R
    *   Yellow --> B
    */

    public String getString() {
        HashMap<Integer, String> sortedMap = sortByKeys(hashMap);
        stringBuilder.setLength(0);

        for (int key : sortedMap.keySet()) {
            if (sortedMap.get(key).equals("#FFA500")) {
                stringBuilder.append("U");
            } else if (sortedMap.get(key).equals("#FF0000")) {
                stringBuilder.append("D");
            } else if (sortedMap.get(key).equals("#FFFFFF")) {
                stringBuilder.append("F");
            } else if (sortedMap.get(key).equals("#FFFF00")) {
                stringBuilder.append("B");
            } else if (sortedMap.get(key).equals("#0000FF")) {
                stringBuilder.append("R");
            } else {
                stringBuilder.append("L");
            }
        }

        return stringBuilder.toString();
    }
}