package ver2;

import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] cookies;

    private static boolean canGive(int mid){
        int cnt = 0;

        for(int cookie : cookies){
            cnt += cookie / mid;
        }

        return cnt >= n ? true : false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int start = 1;
        int end = -1;
        int ans = 0;

        cookies = new int[m];

        for(int i = 0 ; i < m; i++){
            int c = sc.nextInt();
            end = Math.max(c, end);
            cookies[i] = c;
        }

        while(start <= end){
            int mid = (start + end) / 2;

            if(canGive(mid)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}

/*
# 카테고리
이분탐색
# 접근 방식
길이의 `최댓값`을 구하는 문제이다. 최댓값을 구해주는 이분탐색의 로직을 작성하였는데,
만약 canGive 메서드가 true를 반환하면 start의 값을 mid + 1로 아니라면 mie -1 로 간격을 줄여가면서 탐색하는 방식으로 해결했다.

# 문제 링크
https://www.acmicpc.net/problem/16401
 */



