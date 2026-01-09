package SWEA_5663_줄기세포배양;
import java.util.*;

public class Solution {
    public static class Cell {
        int x;
        int y;
        int power;
        int status;

        public Cell(int x, int y, int power, int status){
            this.x = x;
            this.y = y;
            this.power = power;
            this.status = status;
        }
    }
    static int time;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1 ; tc <= T;tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            map = new int[N][M];
            time = K;

            Queue<Integer> q = new LinkedList<>();

            for(int i = 0 ; i < N; i++){
                for(int j = 0 ; j < M; j++){
                    int n = sc.nextInt();
                    map[i][j] = n;

                    if(n != 0){
                    }
                }
            }
        }

    }
}
