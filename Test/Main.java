package Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
     HashMap hashMap = new HashMap();
     hashMap.put("김주형", "1");
     hashMap.put("김기창", "2");
     hashMap.put("김현재", "3");
     hashMap.put("신승호", "4");
     hashMap.put("박희연", "5");
     hashMap.put("최장우", "6");

     LinkedHashMap linkedHashMap = new LinkedHashMap();

     linkedHashMap.put("김주형", "1");
     linkedHashMap.put("김기창", "2");
     linkedHashMap.put("김현재", "3");
     linkedHashMap.put("신승호", "4");
     linkedHashMap.put("박희연", "5");
     linkedHashMap.put("최장우", "6");

    System.out.println("HashMap: " + hashMap);
    System.out.println("LinkedHashMap " + linkedHashMap);
    }


}
