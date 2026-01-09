package BOJ_9084_동전;
import java.util.*;

public class Main {
    public static int solution(int[] coins, int weight){
        int[] d = new int[weight +1];
        d[0] = 1;

        for(int coin : coins){
            for(int i = coin; i <= weight; i++){
                d[i] = d[i] + d[i - coin];
            }
        }
        return d[weight];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        while(T-->0){
            int n = sc.nextInt();
            int[] coins = new int[n];

            for(int i = 0 ; i < n; i++){
                coins[i] = sc.nextInt();
            }

            int weight = sc.nextInt();

            System.out.println(solution(coins, weight));
        }

    }
}
