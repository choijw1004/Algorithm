package ver2.BOJ_햄버거분해;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for(int i = 0 ; i < n; i++){
            if(arr[i] == 'P'){
                for(int j = Math.max(i - m, 0); j <= Math.min(n-1, i + m); j++){
                    if(arr[j] == 'H' && !visited[j]){
                        visited[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

/*
# 카테고리
브루트포스
# 접근 방식

# 문제 링크
https://www.acmicpc.net/problem/19941
 */
