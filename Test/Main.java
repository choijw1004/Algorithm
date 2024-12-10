package Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
     HashMap hashMap = new HashMap();
     hashMap.put("김주형", "농협");
     hashMap.put("김기창", "IBK 시스템");
     hashMap.put("김현재", "구글");
     hashMap.put("신승호", "현대오토에버");
     hashMap.put("박희연", "네이버");
     hashMap.put("최장우", "토스");

     LinkedHashMap linkedHashMap = new LinkedHashMap();

     linkedHashMap.put("김주형", "농협");
     linkedHashMap.put("김기창", "IBK 시스템");
     linkedHashMap.put("김현재", "구글");
     linkedHashMap.put("신승호", "현대오토에버");
     linkedHashMap.put("박희연", "네이버");
     linkedHashMap.put("최장우", "토스");

    System.out.println("HashMap: " + hashMap);
    System.out.println("LinkedHashMap " + linkedHashMap);
    }


}
