package BOJ_2109_순회강연;
import java.util.*;

public class Main {
    public static int solution(int[][] lectures){
        int ans = 0;
        int maxD = -1;
        int lidx = lectures.length - 1;

        Arrays.sort(lectures, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < lectures.length; i++) {
            maxD = Math.max(lectures[i][1], maxD);
        }

        for (int curr = maxD; curr >= 1; curr--) {
            while (lidx >= 0 && lectures[lidx][1] >= curr) {
                pq.offer(lectures[lidx][0]);
                lidx--;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            lectures[i][0] = sc.nextInt(); // 강연 수익
            lectures[i][1] = sc.nextInt(); // 강연 마감 기한
        }

        System.out.println(solution(lectures));
    }
}
