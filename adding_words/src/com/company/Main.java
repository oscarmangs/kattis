package com.company;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> list = createList("input.txt");
        BiMap<String, Integer> biMap = HashBiMap.create();

        for (String s : list) {
            if (s.contains("def")) {
                biMap.put(s.split(" ")[1], Integer.parseInt(s.split(" ")[2]));
            }
            if (s.contains("calc")) {
                String[] arr = s.split(" ");
                String calculation = "";
                for (int i = 0; i < arr.length; i++){
                   if(arr[i].contains("calc")){
                   }
                   else if(biMap.containsKey(arr[i])){
                       calculation += String.valueOf(biMap.get(arr[i]));
                    }
                   else if(arr[i].contains("+")){
                       calculation += "+";
                   }
                   else if(arr[i].contains("-")){
                       calculation += "-";
                   }
                   else if(arr[i].contains("=")){
                       String[] string = s.split(" ", 2);
                       int result = EvaluateString.evaluate(calculation);
                       if(getKey(biMap, result)!=null){
                           System.out.println(string[1] + " " + getKey(biMap, result));
                       }else if(getKey(biMap, result)==null){
                           System.out.println(string[1] +" unknown");
                       }
                   }
                   else if (!biMap.containsKey(arr[i])){
                       String[] string = s.split(" ", 2);
                       System.out.println(string[1] +" unknown");
                       break;
                    }
                }
            }
        }
    }
    public static ArrayList<String> createList (String listName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(listName));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }
    public static <K, V> K getKey(BiMap<K, V> map, V value) {
        return map.inverse().get(value);
    }
}
