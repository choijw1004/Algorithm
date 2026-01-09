package BOJ_21921_블로그;
import java.util.*;

public class Main {
    private static void solution(int[] peoples, int k) {
        int n = peoples.length;
        int left = 0;
        long sum = 0, maxSum = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            sum += peoples[right];

            if (right - left + 1 > k) {
                sum -= peoples[left];
                left++;
            }

            if (right - left + 1 == k) {
                if (sum > maxSum) {
                    maxSum = sum;
                    count = 1;
                } else if (sum == maxSum) {
                    count++;
                }
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] peoples = new int[n];

        for(int i = 0 ; i < n; i++) peoples[i] = sc.nextInt();
        solution(peoples, k);

    }
}
