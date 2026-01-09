package BOJ_1715_카드정렬하기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for(int i = 0 ; i < N; i++){
            pq.offer(sc.nextInt());
        }

        while(pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();

            sum += a + b;

            pq.offer(a + b);
        }
        System.out.println(sum);
    }
}
