package BOJ_20440_니싫내싫;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] starts = new int[N];
        int[] ends   = new int[N];
        for (int i = 0; i < N; i++) {
            starts[i] = sc.nextInt();
            ends[i]   = sc.nextInt();
        }
        sc.close();

        // 1) 정렬
        Arrays.sort(starts);
        Arrays.sort(ends);

        // 2) 투 포인터 스윕
        int i = 0, j = 0;
        int curr = 0, maxCnt = 0;
        int maxStart = 0, maxEnd = 0;
        boolean inMaxInterval = false;

        // 입장·퇴장 이벤트를 모두 처리
        while (i < N || j < N) {
            // 입장만 남았거나, (입장 < 퇴장)일 땐 입장 이벤트
            if (j == N || (i < N && starts[i] < ends[j])) {
                curr++;
                // 최대가 되면 구간 시작 기록
                if (curr > maxCnt) {
                    maxCnt = curr;
                    maxStart = starts[i];
                    inMaxInterval = true;
                }
                i++;
            }
            // 그 외(퇴장만 남았거나 퇴장이 앞서면) 퇴장 이벤트
            else {
                // 최대 구간이 끝나면 구간 종료 기록
                if (inMaxInterval && curr == maxCnt) {
                    maxEnd = ends[j];
                    inMaxInterval = false;
                }
                curr--;
                j++;
            }
        }

        // 3) 결과 출력
        System.out.println(maxCnt);
        System.out.printf("%d %d\n", maxStart, maxEnd);
    }
}
