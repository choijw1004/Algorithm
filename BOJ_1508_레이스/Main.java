package BOJ_1508_레이스;
import java.util.*;

public class Main {
    public static String solution(int n, int m, int k, int[] points){
        int[] ans = new int[k];
        //직선 n
        //심판수 m
        //심판위치


        int left = 1;
        int right = n;

        while(left <= right){

            int mid = (left + right) /2;



        }

        return Arrays.toString(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] points = new int[k];

        for(int i = 0 ; i < k ;i++){
            points[i]  = sc.nextInt();
        }

        System.out.println(solution(n,m,k,points));
    }
}
