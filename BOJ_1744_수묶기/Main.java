package BOJ_1744_수묶기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negQueue = new PriorityQueue<>();

        int ones = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                posQueue.add(num);
            } else if (num == 1) {
                ones++;
            } else {
                negQueue.add(num);
            }
        }

        while (posQueue.size() > 1) {
            int a = posQueue.poll();
            int b = posQueue.poll();
            result += a * b;
        }
        if (!posQueue.isEmpty()) {
            result += posQueue.poll();
        }

        while (negQueue.size() > 1) {
            int a = negQueue.poll();
            int b = negQueue.poll();
            result += a * b;
        }
        if (!negQueue.isEmpty()) {
            result += negQueue.poll();
        }

        result += ones;

        System.out.println(result);
    }
}

