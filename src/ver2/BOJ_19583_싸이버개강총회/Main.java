package ver2.BOJ_19583_싸이버개강총회;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] pa = br.readLine().split(" ");
        String[] t1 = pa[0].split(":");
        String[] t2 = pa[1].split(":");
        String[] t3 = pa[2].split(":");

        int start = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
        int end = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);
        int chatEnd = Integer.parseInt(t3[0]) * 60 + Integer.parseInt(t3[1]);

        HashMap<String, int[]> map = new HashMap<>();

        String line;

        while((line = br.readLine()) != null && !line.isEmpty()){
            String[] pa1 = line.split(" ");
            String[] pa2 = pa1[0].split(":");
            int time = Integer.parseInt(pa2[0]) * 60 + Integer.parseInt(pa2[1]);
            String name = pa1[1];

            if(time <= start){
                map.computeIfAbsent(name, k -> new int[2])[0]++;
            }
            else if(time >= end && time <= chatEnd){
                map.computeIfAbsent(name,k -> new int[2])[1]++;
            }
        }

        int ans = 0;

        for(Map.Entry<String, int[]> entry: map.entrySet()){
            int a = entry.getValue()[0];
            int b = entry.getValue()[1];
            if(a >= 1 && b >= 1) ans++;
        }
        System.out.println(ans);


    }
}

/*
# 카테고리
Hash Map, 정렬

# 접근 방식
Hash Map, 정렬

# 문제 링크
https://www.acmicpc.net/problem/19583
 */