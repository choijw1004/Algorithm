package SWEA_17299_최소덧셈;
import java.util.*;

public class Solution {
    static int T;
    static String N;
    static int minSum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.next();
            minSum = Integer.MAX_VALUE; // 초기값을 충분히 큰 값으로 설정

            for (int i = 1; i < N.length(); i++) { // i = 1부터 시작
                int leftNum = (i == 0) ? 0 : Integer.valueOf(N.substring(0, i));
                int rightNum = (i == N.length()) ? 0 : Integer.valueOf(N.substring(i));

                int tmpSum = leftNum + rightNum;

                if (tmpSum < minSum) { // 최소값 갱신
                    minSum = tmpSum;
                }
            }


            System.out.println("#" + tc + " " + minSum);
        }
    }
}
