package ver2.BOJ_부분합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(end < n){
            sum += nums[end];

            while(sum >= k){
                sum -= nums[start];
                start++;
            }
            min = Math.min(min, end - start + 1);
            end++;

        }

        if(min == Integer.MAX_VALUE) min = 0;

        System.out.println(min);
    }
}
