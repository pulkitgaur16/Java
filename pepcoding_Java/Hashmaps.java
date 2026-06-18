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

    public static void getCommonElement(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> hm1= new HashMap<>();
        HashMap<Integer, Integer> hm2= new HashMap<>();

        for(int num: arr1){
            if(hm1.get(num)==null){
                hm1.put(num, 1);
            }
            else{
                hm1.put(num, hm1.get(num) + 1);
            }
        }
        for(int val: arr2){
            if(hm1.containsKey(val)){
                System.out.print(val + " ");
                hm1.remove(val);
            }
        }
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

        // char CharwithHighestfreq= highestfreq("abbbc");
        // System.out.println(CharwithHighestfreq);

        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();

        int[] arr1= new int[n];
        int[] arr2= new int[m];

        for(int i=0; i<n; i++){
            arr1[i]= scn.nextInt();
        }

        for(int i=0; i<m; i++){
            arr2[i]= scn.nextInt();
        }

        getCommonElement(arr1, arr2);
    }
}
