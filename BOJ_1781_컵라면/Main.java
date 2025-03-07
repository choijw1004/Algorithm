package BOJ_1781_컵라면;
import java.util.*;

public class Main {
    public static int solution(int[][] problems){
        int ans = 0;

        Arrays.sort(problems, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] problem : problems){
            int dl = problem[0];
            int ramen = problem[1];

            pq.offer(ramen);

            if(pq.size() > dl && pq.peek() <= ramen) pq.poll();
        }

        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] problem = new int[n][2];

        for(int i = 0 ; i < n; i++){
            problem[i][0] = sc.nextInt();
            problem[i][1] = sc.nextInt();
        }
        System.out.println(solution(problem));

    }
}
