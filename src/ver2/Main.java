package ver2;

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
완전 탐색

# 접근 방식
반복문으로 쉽게 해결할 수 있는 문제이다.

# 문제 링크
https://www.acmicpc.net/problem/19941
 */
