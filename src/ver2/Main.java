package ver2;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int ans = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(end < n){
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while(map.size() > 2){
                map.put(arr[start], map.getOrDefault(arr[start],0) - 1);
                if(map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            ans = Math.max(end - start + 1, ans);
            end++;

        }

        System.out.println(ans);

    }
}

/*
# 카테고리
투 포인터, 슬라이딩 윈도우

# 접근 방식
투 포인터와 슬라이딩 윈도우를 활용하여 해결했다.

# 문제 링크
https://www.acmicpc.net/problem/30804
 */

