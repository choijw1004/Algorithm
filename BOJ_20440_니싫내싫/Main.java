package BOJ_20440_니싫내싫;
import java.util.*;

public class Main {
    private static void solution(int[][] mosqs){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = -1;

        for(int[] mosq : mosqs){
            int start = mosq[0];
            int end = mosq[1];
        }

        Arrays.sort(mosqs, (a,b) -> a[1] - b[1]);



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mosqs = new int[n][2];
        for(int i = 0 ; i < n; i++) {
            mosqs[i][0] = sc.nextInt();
            mosqs[i][1] = sc.nextInt();
        }
        solution(mosqs);
    }
}
