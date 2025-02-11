package BOJ_17298_오큰수;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i]){
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
        }
        System.out.println(sb);


    }
}
