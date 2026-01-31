package ver2.BOJ_겹치는건싫어;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int ans = -1;

        while(end < n){

            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while(map.get(arr[end]) > k){
                map.put(arr[start], map.getOrDefault(arr[start], 0) -1);
                start++;

            }
            ans = Math.max(ans, end - start + 1);
            end++;

        }

        System.out.println(ans);

    }
}
