package BOJ_3190_뱀;
import java.util.*;

public class Main {

    public static class Snake {
        LinkedList<int[]> point;
        int dir;

        public Snake() {
            point = new LinkedList<>();
            point.add(new int[]{0, 0});
            dir = 0;
        }

        public int[] getHead() {
            return point.getFirst();
        }
    }

    static int N;
    static int[][] map;
    static int K;
    static int time;
    static Map<Integer, Character> dir = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void move(Snake snake, int moveTime) {
        while (time < moveTime) {
            time++;

            int[] head = snake.getHead();
            int nx = head[0] + dx[snake.dir];
            int ny = head[1] + dy[snake.dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || isColide(snake, nx, ny)) {
                System.out.println(time);
                return;
            }

            snake.point.addFirst(new int[]{nx, ny});

            if (map[nx][ny] != 1) {
                snake.point.removeLast();
            } else {
                map[nx][ny] = 0;
            }

            if (dir.containsKey(time)) {
                char changeDir = dir.get(time);
                if (changeDir == 'L') {
                    snake.dir = (snake.dir + 3) % 4;
                } else if (changeDir == 'D') {
                    snake.dir = (snake.dir + 1) % 4;
                }
            }
        }
    }

    public static boolean isColide(Snake snake, int x, int y) {
        for (int[] pos : snake.point) {
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        K = sc.nextInt();
        time = 0;

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x - 1][y - 1] = 1;
        }

        int moveCnt = sc.nextInt();
        for (int i = 0; i < moveCnt; i++) {
            int moveTime = sc.nextInt();
            char changeDirection = sc.next().charAt(0);
            dir.put(moveTime, changeDirection);
        }

        Snake snake = new Snake();
        int maxX = 10000;
        move(snake, maxX);
    }
}
