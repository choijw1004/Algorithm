package BOJ_1114_통나무자르기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();         // 통나무의 전체 길이
        int N = sc.nextInt();         // 자를 수 있는 위치의 개수
        int maxC = sc.nextInt();      // 최대 컷 수

        int[] cuts = new int[N];
        for (int i = 0; i < N; i++) {
            cuts[i] = sc.nextInt();
        }
        Arrays.sort(cuts);

        int left = 1;         // 최소 조각 길이 후보의 하한
        int right = L;        // 최소 조각 길이 후보의 상한
        int best = 0;         // 가능한 최소 조각 길이의 최댓값
        int bestFirstCut = 0; // 최적일 때 첫 번째 컷의 위치

        while (left <= right) {
            int mid = (left + right) / 2; // 후보 최소 길이
            int count = 0;    // 실제로 필요한 컷의 수
            int lastCut = 0;  // 마지막 컷 위치
            int firstCut = 0; // 첫 번째 컷 위치 (최초로 컷한 위치)

            // 각 자를 수 있는 위치에 대해, 최소 길이가 mid가 되는지 검사
            for (int i = 0; i < N; i++) {
                if (cuts[i] - lastCut >= mid) {
                    count++;
                    // 첫 번째 컷 위치 기록
                    if (firstCut == 0) {
                        firstCut = cuts[i];
                    }
                    lastCut = cuts[i];
                }
            }
            // 마지막 조각(마지막 컷 이후의 길이)도 mid 이상이어야 함
            if (L - lastCut < mid) {
                // 마지막 조각 길이가 부족하면 후보 mid는 불가능
                count = maxC + 1; // 강제로 실패하도록 처리
            }

            // 만약 최대 컷 수 이하로 만들 수 있다면, 후보 mid값이 가능
            if (count <= maxC) {
                best = mid;
                bestFirstCut = firstCut;
                left = mid + 1; // 더 큰 최소 길이가 가능한지 탐색
            } else {
                right = mid - 1;
            }
        }

        System.out.println(best + 1 + " " + bestFirstCut);
    }
}
