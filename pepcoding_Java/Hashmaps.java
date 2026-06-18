import java.io.*;
import java.util.*;

public class Hashmaps {
    //used to store information like population maps
    // it solves many problems in O(1) time complexity

    // functions of hashmaps
    //put(), get(), containsKey(), keySet() -> all works in O(1)

    public static char highestfreq(String str){
        HashMap<Character, Integer> hm = new HashMap<>();
        int freq=0;
        char ans= '\0';

        for(char ch: str.toCharArray()){
            if(hm.get(ch)==null){
                hm.put(ch, 1);
            }
            else{
                hm.put(ch, hm.get(ch) + 1);
            }
        }

        for(char key: hm.keySet()){
            int val= hm.get(key);
            if(val>freq){
                freq=val;
                ans= key;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        HashMap<String, Integer> hm= new HashMap<>();
        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pak", 30);
        hm.put("US", 20);
       // hm.put("Germany"); // gives error

        //System.out.println(hm); // order of elements is not in our control

        hm.put("Nigeria", 5);
        hm.put("US", 25);

        // System.out.println(hm);

        // System.out.println(hm.get("India"));
        // System.out.println(hm.get("Utopia"));

        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Utopia"));

        Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for(String key: hm.keySet()){
        //     Integer val = hm.get(key);
        //     System.out.println(key + " " + val);
        // }

        char CharwithHighestfreq= highestfreq("abbbc");
        System.out.println(CharwithHighestfreq);
    }
}
