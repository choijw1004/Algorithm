package BOJ_2696_중앙값구하기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- >0){

            int N = sc.nextInt();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            int cnt = 0;

            for(int i = 1; i < N + 1 ;i++){
                int num = sc.nextInt();

                if(minHeap.size() == maxHeap.size()){
                    maxHeap.offer(num);
                }
                else{
                    minHeap.offer(num);
                }

                if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                    int max = maxHeap.poll();
                    int min = minHeap.poll();

                    maxHeap.offer(min);
                    minHeap.offer(max);
                }
                if(i % 2 == 1){
                    cnt++;
                    sb.append(maxHeap.peek()).append(" ");

                }
            }
            System.out.println(cnt);
            System.out.println(sb);
        }
    }
}
