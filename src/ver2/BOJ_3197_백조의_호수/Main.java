package ver2.BOJ_3197_백조의_호수;

import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static List<int[]> startL;
    static List<int[]> startX;
    private static boolean dfs(int[][] dist, boolean[][] visit, int mid, int sx, int sy){

        if(sx == startL.get(1)[0] && sy == startL.get(1)[1]) return true;

        for(int i = 0 ; i <4; i++){
            int nx = sx + dx[i];
            int ny = sy + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m
                    && !visit[nx][ny]
                    && dist[nx][ny] <= mid){
                visit[nx][ny] = true;
                if(dfs(dist, visit, mid, nx,ny)) return true;
            }
        }
        return false;
    }
    private static boolean canGo(int[][] dist, int mid){
        boolean[][] visit = new boolean[n][m];
        visit[startL.get(0)[0]][startL.get(0)[1]] = true;

        return dfs(dist, visit, mid, startL.get(0)[0], startL.get(0)[1]);
    }
    private static boolean isNear(int x, int y){
        boolean flag = false;

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(map[nx][ny] != 'X' ) flag = true;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];

        startL = new ArrayList<>();
        startX = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < m; j++){
                char c = line.charAt(j);

                if(c == 'L') startL.add(new int[]{i,j});

                map[i][j] = c;
            }
        }


        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if((map[i][j] == 'X') && isNear(i,j)) startX.add(new int[]{i,j});
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        visited = new boolean[n][m];

        for(int i= 0 ; i < startX.size(); i++){
            q.add(startX.get(i));
            visited[startX.get(i)[0]][startX.get(i)[1]] = true;
            dist[startX.get(i)[0]][startX.get(i)[1]] = 1;
        }

        int day = 2;
        while(!q.isEmpty()){
            int size = q.size();

            while(size -- > 0){
                int[] curr = q.poll();

                for(int i = 0 ; i < 4; i++){
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 'X'){
                        dist[nx][ny] = day;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            day++;
        }

        int left = 1;
        int right= 3000;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canGo(dist, mid)) {
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }

        }

        System.out.println(ans);
    }
}

/*
# 카테고리
2차원 배열, DFS, BFS

# 접근 방식
가장자리에 있는 얼음들의 좌표를 구해주고 초기 시작 큐에 담아서 사이즈 별 순회로 dist 배열에 각 좌표에 있는 얼음이 며칠만에 녹는지 구해준다.
이분탐색으로 백조가 만날 수 있는 최솟값을 구하고 업데이트된 dist 배열을 가지고 그 시간안에 dfs로 두 마리의 백조가 만날 수 있는지 도달여부를 체크하는 방식으로 해결했다.

# 문제 링크
https://www.acmicpc.net/problem/3197
 */