package BOJ_17352_여러분의다리가되어드리겠습니다;
import java.util.*;

public class Main {
    static int[] islands;

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (x < y) {
            islands[y] = x;
        } else {
            islands[x] = y;
        }
        return true;
    }

    public static int find(int x) {
        if (islands[x] != x) {
            islands[x] = find(islands[x]); // 경로 압축 추가
        }
        return islands[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        islands = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            islands[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                answer.add(i);
            }
        }

        System.out.println(answer.get(0) + " " + answer.get(1));
    }
}
