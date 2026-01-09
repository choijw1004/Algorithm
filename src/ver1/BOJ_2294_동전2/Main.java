package BOJ_2294_동전2;
import java.util.*;

public class Main {
    private static int solution(int n, int k, int[] coins){
        int[] d = new int[k + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        for(int i = 1; i<=k; i++){
            for(int c : coins){
                if(i >= c && d[i-c] != Integer.MAX_VALUE){
                    d[i] = Math.min(d[i], d[i-c] + 1);
                }
            }
        }

        return d[k] == Integer.MAX_VALUE ? -1 : d[k];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println(solution(n,k,coins));

    }
}
