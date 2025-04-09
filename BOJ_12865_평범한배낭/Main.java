package BOJ_12865_평범한배낭;
import java.util.*;

public class Main {
    public static int solution(int weight, int[][] items){
        int ans = 0;
        int n = items.length;

        int[] d = new int[weight + 1];


        for(int[] item : items){
            int w = item[0];
            int v = item[1];

            for(int j = weight; j >= w; j--){
                d[j] = Math.max(d[j], d[j-w] + v);
            }

        }
        ans = d[weight];


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int weight = sc.nextInt();
        int[][] items = new int[n][2];

        for(int i = 0 ; i < n; i++){
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }

        System.out.println(solution(weight, items));
    }
}
