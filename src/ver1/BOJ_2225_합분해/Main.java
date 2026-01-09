package BOJ_2225_합분해;
import java.util.*;

public class Main {
    public static int solution(int n, int k){
        int[] d = new int[n+1];
        d[0] = 1;
        //1 0, 0 1
        d[1] = 2;
        //2 0, 1 1, 0 2
        d[2] = 3;
        //003 030 300 0012 0021

        for(int i = 0 ; i < n+1; i++){
        }
        return 3;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n,k));
    }
}
