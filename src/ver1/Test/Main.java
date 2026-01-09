package Test;

import java.util.Scanner;

public class Main {
    static int r,c,sx,sy;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        sx= sc.nextInt();
        sy = sc.nextInt();

    }
}
