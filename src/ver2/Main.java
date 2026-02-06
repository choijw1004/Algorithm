package ver2;

import java.util.*;

class Point{
    int x,y;
    boolean isOn;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y, boolean isOn){
        this.x = x;
        this.y = y;
        this.isOn = isOn;
    }

    void on(){
        this.isOn = true;
    }
}


public class Main {
    static int n,m,cnt;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Point[][] map;
    static boolean[][] visited;
    static HashMap<String, List<String>> infos;

    private static void bfs(){
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Point(0,0));

        while(!q.isEmpty()){
            int size = q.size();

            while(size -- >0){
                Point curr = q.poll();
                String key = curr.x + " " + curr.y;
                List<String> tmp = infos.get(key);

                if(tmp != null) {
                    for (int i = 0; i < tmp.size(); i++) {
                        String[] sp = tmp.get(i).split(" ");
                        int lightX = Integer.parseInt(sp[0]);
                        int lightY = Integer.parseInt(sp[1]);
                        if(!map[lightX][lightY].isOn) {
                            map[lightX][lightY].on();
                            cnt++;

                            if (!visited[lightX][lightY]) {
                                for (int d = 0; d < 4; d++) {
                                    int adjX = lightX + dx[d];
                                    int adjY = lightY + dy[d];

                                    if (adjX >= 0 && adjY >= 0 && adjX < n && adjY < n
                                            && visited[adjX][adjY]) {
                                        q.add(new Point(lightX, lightY));
                                        visited[lightX][lightY] = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                for(int i = 0 ; i < 4; i++){
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if(nx < 0 || ny < 0 || nx > n-1 || ny > n-1 || visited[nx][ny]) continue;

                    if(map[nx][ny].isOn){
                        q.add(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cnt = 1;
        map = new Point[n][n];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(i == 0 && j == 0) map[i][j] = new Point(0,0,true);

                else map[i][j] = new Point(i,j, false);
            }
        }

        visited = new boolean[n][n];
        infos = new HashMap<>();

        while(m -- > 0){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int nx = sc.nextInt() - 1;
            int ny = sc.nextInt() - 1;

            String key = x + " " + y;
            String val = nx + " " + ny;

            infos.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        bfs();

        System.out.println(cnt);
    }
}

/*
# 카테고리
2차원 배열, 그래프, BFS

# 접근 방식
큐에 담는 형식이 불을 킬 수 있는 공간과 불을 킬 수 있고 인접한 공간을 둘로 나눠서 큐에 넣는 방법으로 우선순위를 처리하여 해결하였다.

# 문제 링크
https://www.acmicpc.net/problem/11967
 */