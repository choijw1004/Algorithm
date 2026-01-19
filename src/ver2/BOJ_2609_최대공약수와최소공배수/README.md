# BOJ_2609_최대공약수와최소공배수

## 문제 링크
https://www.acmicpc.net/problem/2609

## 카테고리
`수학` `유클리드 호재법`

## 접근 방식
가장 기본적인 두 수의 최대공약수, 최소공배수를 구하는 문제이다.

getGCD 메서드는
두 수 a,b를 파라미터로 받고

b가 0이면 a를 return
0이 아니면 재귀로 b, a%b 로 모듈러 연산을 해준다

getLCM 메서드는
두 수 a,b를 파라미터로 받고
a*b / getGCD(a,b)를 반환하게 된다.

## 코드
```java
package ver2.BOJ_2609_최대공약수와최소공배수;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGCD(a,b));
        System.out.println(getLCM(a,b));
    }

    private static int getGCD(int a, int b){
        if(b == 0) return a;
        else return getGCD(b, a%b);
    }

    private static int getLCM(int a, int b){
        return (a * b) / getGCD(a,b);
    }
}
```
