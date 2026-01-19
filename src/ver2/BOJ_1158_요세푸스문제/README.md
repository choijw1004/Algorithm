# BOJ_1158_요세푸스문제

## 문제 링크
https://www.acmicpc.net/problem/1158

## 카테고리
`자료구조` `큐`

## 접근 방식
문제를 읽고 원형 큐로 접근해야겠다고 생각했고 순서를 고려하기위해 poll과 add를 반복하여 순열을 뽑아내는 방식으로 해결했다.

## 코드
```java
package ver2.BOJ_1158_요세푸스문제;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(q.size() > 0){
            int num = 0;

            for(int i = 0 ;  i < k; i++){
                int tmp = q.poll();

                if(i == k-1){
                    num = tmp;
                    ans.add(num);
                }
                else q.add(tmp);
            }
        }


        for(int i = 0 ; i < ans.size(); i++){
            if(ans.size() == 1) System.out.println("<" + 1 + ">");
            else if(i == 0) System.out.print("<" + ans.get(i));
            else if(i == ans.size() - 1) System.out.print(", " + ans.get(i) + ">");
            else System.out.print(", " + ans.get(i));
        }
    }
}
```
