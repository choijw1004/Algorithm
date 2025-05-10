package BOJ_1535_안녕;
import java.util.*;

public class Main {
    private static int solution(int[][] peoples){
        int n = peoples.length;
        int[] d = new int[100];
        d[0] = 0;

        for(int[] p: peoples){
            int cost = p[0];
            int profit = p[1];

            for(int i = d.length-1; i - cost >= 0; i--){
                d[i] = Math.max(d[i], d[i-cost] + profit);
            }
        }
        return d[99];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] peoples = new int[n][2];
        for(int i = 0 ; i < n; i++) peoples[i][0] = sc.nextInt();
        for(int i = 0 ; i < n; i++) peoples[i][1] = sc.nextInt();

        System.out.println(solution(peoples));

    }
}
