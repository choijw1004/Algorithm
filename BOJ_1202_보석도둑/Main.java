package BOJ_1202_보석도둑;
import java.util.*;

public class Main {
    public static long solution(int[][] gems, int[] bags){
        long ans = 0;
        int n = bags.length;
        int m = gems.length;
        int gIdx = 0;
        PriorityQueue<Integer> gq = new PriorityQueue<>(Collections.reverseOrder());

        //무게가 적고 가치가 높은 순
        Arrays.sort(gems, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(b[1], a[1]);
        });

        Arrays.sort(bags);

        for(int bagWeight : bags){
            while(gIdx < m && gems[gIdx][0] <= bagWeight){
                gq.offer(gems[gIdx][1]);
                gIdx++;
            }
            if(!gq.isEmpty()) ans += gq.poll();
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] gems = new int[n][2];

        for(int i = 0 ; i < n; i++){
            gems[i][0] = sc.nextInt();
            gems[i][1] = sc.nextInt();
        }
        int[] bags = new int[k];

        for(int i = 0 ; i < k ; i++){
            bags[i] = sc.nextInt();
        }
        System.out.println(solution(gems, bags));
    }
}
