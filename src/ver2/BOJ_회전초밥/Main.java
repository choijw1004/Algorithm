package ver2.BOJ_회전초밥;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int coupon = sc.nextInt();
        int[] sushi = new int[2 * n];

        for(int i = 0 ; i < n; i++){
            int s = sc.nextInt();
            sushi[i] = s;
            sushi[i + n] = s;
        }

        int size = k;

        int start = 0;
        int end = 0;
        int max = -1;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(end < sushi.length){
            if(end - start + 1 < size){
                map.put(sushi[end],map.getOrDefault(sushi[end],0) + 1);
                end++;
            }

            else{
                map.put(sushi[end],map.getOrDefault(sushi[end],0) + 1);

                if(!map.containsKey(coupon)){
                    max = Math.max(map.size() + 1, max);
                }
                else{
                    max = Math.max(map.size(), max);
                }

                map.put(sushi[start],map.getOrDefault(sushi[start],0) - 1);
                if(map.get(sushi[start]) == 0) map.remove(sushi[start]);

                start++;
                end++;
            }
        }
        System.out.println(max);
    }
}
