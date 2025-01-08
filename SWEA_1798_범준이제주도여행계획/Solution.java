package SWEA_1798_범준이제주도여행계획;

import java.util.*;

public class Solution {
    static int N, M, Airport, Answer;
    static int[][] Distance = new int[40][40];
    static boolean[] visited = new boolean[40];
    static List<Integer> Hotel = new ArrayList<>();
    static List<Integer> AnswerRoute = new ArrayList<>();
    static List<TourPoint> Tour = new ArrayList<>();

    static class TourPoint {
        int id, playTime, satisfaction;

        public TourPoint(int id, int playTime, int satisfaction) {
            this.id = id;
            this.playTime = playTime;
            this.satisfaction = satisfaction;
        }
    }

    public static void dfs(int cur, int day, int satisfy, int time, int depth, List<Integer> route) {
        if (cur == Airport && day == M && depth != 0) {
            if (satisfy > Answer) {
                Answer = satisfy;
                AnswerRoute = new ArrayList<>(route);
            }
            return;
        }

        boolean flag = false;
        for (TourPoint point : Tour) {
            int next = point.id;
            int playTime = point.playTime;
            int nSatisfy = point.satisfaction;
            int moveTime = Distance[cur][next];

            if (visited[next] || cur == next) {
                continue;
            }
            if (time + moveTime + playTime > 540) {
                continue;
            }

            flag = true;
            visited[next] = true;
            route.add(next);
            dfs(next, day, satisfy + nSatisfy, time + moveTime + playTime, depth + 1, route);
            route.remove(route.size() - 1);
            visited[next] = false;
        }

        if (!flag) {
            if (day == M) {
                if (time + Distance[cur][Airport] <= 540) {
                    route.add(Airport);
                    dfs(Airport, day, satisfy, time + Distance[cur][Airport], depth + 1, route);
                    route.remove(route.size() - 1);
                }
            } else {
                for (int hotelNum : Hotel) {
                    if (time + Distance[cur][hotelNum] <= 540) {
                        route.add(hotelNum);
                        dfs(hotelNum, day + 1, satisfy, 0, depth + 1, route);
                        route.remove(route.size() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            Hotel.clear();
            AnswerRoute.clear();
            Tour.clear();
            Answer = 0;
            Arrays.fill(visited, false);
            for (int[] row : Distance) {
                Arrays.fill(row, 0);
            }

            N = sc.nextInt();
            M = sc.nextInt();

            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int a = sc.nextInt();
                    Distance[i][j] = a;
                    Distance[j][i] = a;
                }
            }

            for (int i = 1; i <= N; i++) {
                String type = sc.next();
                if (type.equals("A")) {
                    Airport = i;
                } else if (type.equals("H")) {
                    Hotel.add(i);
                } else {
                    int playTime = sc.nextInt();
                    int satisfaction = sc.nextInt();
                    Tour.add(new TourPoint(i, playTime, satisfaction));
                }
            }

            List<Integer> route = new ArrayList<>();
            dfs(Airport, 1, 0, 0, 0, route);

            System.out.print("#" + tc + " " + Answer + " ");
            if (Answer != 0) {
                for (int i : AnswerRoute) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }
}
