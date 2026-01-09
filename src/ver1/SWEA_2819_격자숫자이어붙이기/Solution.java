package SWEA_2819_격자숫자이어붙이기;

import java.util.*;

public class Solution {

    static int[][] board;
    static int N;
    //상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static HashSet<String> hashSet;

    public static boolean isValidate(int x, int y){
        boolean flag = false;

        if(x >= 0 && x < N && y >= 0 && y <N){
            flag = true;
        }

        return flag;
    }
    public static void move(int x, int y, int depth, String str){
        if(depth == 6){
            hashSet.add(str);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isValidate(nx,ny)){
                move(nx, ny, depth +1, str + board[nx][ny]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T ; tc++) {

            board = new int[4][4];
            N = 4;
            hashSet = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    move(i, j, 0, "" + board[i][j]);
                }
            }
            System.out.println("#" + tc + " " +hashSet.size());
        }
    }
}
