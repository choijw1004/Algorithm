package BOJ_1697_숨바꼭질;
import java.util.*;

public class Main {

    public static int solution(int N, int M) {
        if (N == M) return 0;

        int time = 0;
        int MAX = 100000;
        boolean[] visited = new boolean[MAX + 1]; // 0 ~ 100000
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int size = q.size(); // 현재 레벨에 있는 노드 수
            for (int i = 0; i < size; i++) {
                int cx = q.poll();

                // 이동 가능한 3가지 경우
                int[] next = { cx - 1, cx + 1, cx * 2 };
                for (int nx : next) {
                    if (nx < 0 || nx > MAX || visited[nx])
                        continue;

                    if (nx == M) {
                        return time + 1;
                    }

                    visited[nx] = true;
                    q.offer(nx);
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(solution(N, M));
    }
}
