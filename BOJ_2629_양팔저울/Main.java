package BOJ_2629_양팔저울;
import java.util.*;

public class Main {
    public static String solution(int[] bases, int[] targets){
        StringBuilder sb = new StringBuilder();






        return sb.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bases = new int[n];
        for(int i = 0 ; i < n; i++){
            bases[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i = 0 ; i < m; i++){
            targets[i] = sc.nextInt();
        }
        System.out.println(solution(bases, targets));

    }
}
