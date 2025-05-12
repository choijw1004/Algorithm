package BOJ_3078_좋은친구;
import java.util.*;

public class Main {
    public static long solution(String[] names, int k) {
        long cnt = 0;
        int[] freq = new int[21];
        Queue<Integer> window = new LinkedList<>();

        for (String name : names) {
            int len = name.length();
            cnt += freq[len];

            freq[len]++;
            window.offer(len);

            if (window.size() > k) {
                int old = window.poll();
                freq[old]--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        System.out.println(solution(names, k));
    }
}
