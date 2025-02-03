package BOJ_13975_파일합치기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- >0){
            int N = sc.nextInt();
            long cost = 0;

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i = 0 ; i < N; i++){
                long num = sc.nextInt();
                pq.offer(num);
            }


            while(pq.size() > 1){
                long n1 = pq.poll();
                long n2 = pq.poll();

                cost += n1 + n2;

                pq.offer(n1 + n2);

            }

            System.out.println(cost);
        }
    }
}
