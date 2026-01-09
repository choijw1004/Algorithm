package BOJ_20440_니싫내싫;
import java.util.*;

class Time {
    long start, end;
    public Time(long start, long end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }

        Arrays.sort(arr, Comparator.comparingLong(a -> a[0]));

        PriorityQueue<Time> queue = new PriorityQueue<>(
                (t1, t2) -> t1.end != t2.end
                        ? Long.compare(t1.end, t2.end)
                        : Long.compare(t2.start, t1.start)
        );

        int maxCount = 0;
        long bestStart = 0, bestEnd = 0;

        for (int i = 0; i < n; i++) {
            long curStart = arr[i][0];
            long curEnd = arr[i][1];

            while (!queue.isEmpty() && curStart > queue.peek().end) {
                queue.poll();
            }
            if (!queue.isEmpty() && curStart == queue.peek().end) {
                queue.poll();
            }

            queue.add(new Time(curStart, curEnd));

            if (queue.size() > maxCount) {
                maxCount = queue.size();
                bestStart = curStart;
                bestEnd = queue.peek().end;
            }
        }

        System.out.println(maxCount);
        System.out.println(bestStart + " " + bestEnd);
    }
}
