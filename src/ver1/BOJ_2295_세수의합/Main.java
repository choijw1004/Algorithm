package BOJ_2295_세수의합;

import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static List<Integer> sumList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        sumList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumList.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sumList);

        int answer = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int target = arr[i] - arr[j];

                if (Collections.binarySearch(sumList, target) >= 0) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.println(answer);
    }
}

