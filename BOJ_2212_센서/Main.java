package BOJ_2212_센서;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        if (K >= N) {
            System.out.println(0);
        }

        Arrays.sort(sensors);
        int[] diff = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diff);
        int answer = 0;

        for (int i = 0; i < N - K; i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}
