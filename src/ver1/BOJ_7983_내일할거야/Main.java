package BOJ_7983_내일할거야;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Task[] tasks = new Task[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int t = sc.nextInt();
            tasks[i] = new Task(d, t);
        }

        // 기한 기준 내림차순 정렬
        Arrays.sort(tasks, (a, b) -> b.deadline - a.deadline);

        // 작업 배치
        int currentTime = tasks[0].deadline; // 시작 시간을 가장 늦은 기한으로 설정
        for (Task task : tasks) {
            // 현재 시간과 작업 기한 중 최소값에서 작업 시간만큼 소모
            currentTime = Math.min(currentTime, task.deadline) - task.time;
        }

        // 결과 출력: 남은 시간이 최대 쉴 수 있는 날
        System.out.println(Math.max(0, currentTime));
    }
}

class Task {
    int deadline, time;

    Task(int deadline, int time) {
        this.deadline = deadline;
        this.time = time;
    }
}
