package BOJ_7576_토마토;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] garage;
    static int[][] days;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void print(int[][] days){
        for(int i = 0 ; i < N; i++){
            System.out.println();
            for(int j = 0; j < M; j++){
                System.out.print(days[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        garage = new int[N][M];
        days = new int[N][M];

        Queue<int[]> q = new LinkedList<>();
        int totalTomatoes = 0;
        int ripeTomatoes = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                garage[i][j] = sc.nextInt();
                if (garage[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    ripeTomatoes++;
                } else if (garage[i][j] == 0) {
                    totalTomatoes++;
                }
            }
        }

        if (totalTomatoes == 0) {
            System.out.println(0);
            return;
        }

        int maxDays = 0;

        while (!q.isEmpty()) {
            int[] currTo = q.poll();
            int currX = currTo[0];
            int currY = currTo[1];
            int currDay = currTo[2];

            maxDays = Math.max(maxDays, currDay);

            for (int i = 0; i < 4; i++) {
                int nX = currX + dx[i];
                int nY = currY + dy[i];

                if (nX >= 0 && nY >= 0 && nX < N && nY < M && garage[nX][nY] == 0 && garage[nX][nY] != -1) {
                    garage[nX][nY] = 1;
                    days[nX][nY] = currDay + 1;
                    q.offer(new int[]{nX, nY, currDay + 1});
                    ripeTomatoes++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(garage[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDays);
    }
}

