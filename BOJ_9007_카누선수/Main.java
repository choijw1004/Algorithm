package BOJ_9007_카누선수;

import java.util.*;

public class Main {
    static int maxWeight;

    public static int[] calcuSum(int[] group1, int[] group2) {
        int N = group1.length;
        int[] result = new int[N * N];
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[index++] = group1[i] + group2[j];
            }
        }
        return result;
    }

    public static int findClosestSum(int[] list1, int[] list2) {
        Arrays.sort(list1);
        Arrays.sort(list2);

        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int x : list1) {
            int target = maxWeight - x;

            int left = 0;
            int right = list2.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                int sum = x + list2[mid];
                int diff = Math.abs(maxWeight - sum);

                if (diff < minDiff || (diff == minDiff && sum < closestSum)) {
                    closestSum = sum;
                    minDiff = diff;
                }

                if (list2[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            maxWeight = sc.nextInt();
            int memberCount = sc.nextInt();

            int[][] groups = new int[4][memberCount];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < memberCount; j++) {
                    groups[i][j] = sc.nextInt();
                }
            }

            int[] upGroupsSumList = calcuSum(groups[0], groups[1]);
            int[] downGroupsSumList = calcuSum(groups[2], groups[3]);

            int solMax = findClosestSum(upGroupsSumList, downGroupsSumList);

            System.out.println(solMax);
        }
    }
}
