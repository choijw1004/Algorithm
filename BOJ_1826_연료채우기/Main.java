package BOJ_1826_연료채우기;
import java.util.*;

public class Main {
    public static int solution(int[][] juyus, int end, int m){
        int ans = 0;

        Arrays.sort(juyus, (a,b) -> Integer.compare(a[0],b[0]));
        int n = juyus.length;
        int jidx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(m < end){

            while(jidx < n && juyus[jidx][0] <= m){
                pq.offer(juyus[jidx][1]);
                jidx++;
            }

            if(pq.isEmpty()) return -1;

            m += pq.poll();
            ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] juyus = new int[n][2];

        for(int i = 0 ; i < n; i++){
            juyus[i][0] = sc.nextInt();
            juyus[i][1] = sc.nextInt();
        }
        int end = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solution(juyus, end, m));


    }
}
