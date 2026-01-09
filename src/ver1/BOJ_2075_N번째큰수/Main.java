package BOJ_2075_N번째큰수;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        for(int i = 0 ; i < N * N; i++){
            int num = sc.nextInt();
            pq.add(num);
        }

        System.out.println(pq);

        for(int i = 0 ; i < N; i++){
            ans = pq.poll();
        }


        System.out.println(ans);
    }
}
