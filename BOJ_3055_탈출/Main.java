package BOJ_3055_탈출;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] map = new char[r][c];
        Queue<int[]> waterQ = new LinkedList<>();
        Queue<int[]> hedgehogQ = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++){
            String s = sc.next();
            for (int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S'){
                    hedgehogQ.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else if(map[i][j] == '*'){
                    waterQ.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int time = 0;
        while(!hedgehogQ.isEmpty()){
            int waterSize = waterQ.size();
            for (int i = 0; i < waterSize; i++){
                int[] water = waterQ.poll();
                int wr = water[0];
                int wc = water[1];
                for (int d = 0; d < 4; d++){
                    int nr = wr + dx[d];
                    int nc = wc + dy[d];
                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = '*';
                        waterQ.offer(new int[]{nr, nc});
                    }
                }
            }

            int hedgehogSize = hedgehogQ.size();
            for (int i = 0; i < hedgehogSize; i++){
                int[] hedgehog = hedgehogQ.poll();
                int hr = hedgehog[0];
                int hc = hedgehog[1];
                if(map[hr][hc] == 'D'){
                    System.out.println(time);
                    return;
                }
                for (int d = 0; d < 4; d++){
                    int nr = hr + dx[d];
                    int nc = hc + dy[d];
                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc] == '.' || map[nr][nc] == 'D'){
                        visited[nr][nc] = true;
                        hedgehogQ.offer(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        System.out.println("KAKTUS");
    }
}
