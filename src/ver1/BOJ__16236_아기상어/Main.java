package BOJ__16236_아기상어;
import java.util.*;

class Shark{
    int x;
    int y;
    int size;
    int stack;
}

class Fish{
    int x;
    int y;
    int dist;
}

public class Main {
    static int N;
    static int[][] space;
    static int time;
    //상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static boolean isValidate(int x, int y){
        if(x >= 0 && y >= 0 && x < N && y <N){
            return true;
        }
        return false;
    }

    public static List<Fish> canEat(Shark shark){

        List<Fish> fishes = new ArrayList<>();

        int cx = shark.x;
        int cy = shark.y;

        for(int i = 1 ; i < N; i++){
            for(int j = 0; j < 4; j++){
                int nx = cx + i * dx[j];
                int ny = nx + i * dy[j];
                if(isValidate(nx,ny)) {
                    if (space[nx][ny] == 0) {
                        continue;
                    }
                    if (space[nx][ny] <= shark.size) {
                        Fish fish = new Fish();
                        fish.x = nx;
                        fish.y = ny;
                        fish.dist = i;

                        fishes.add(fish);
                    }
                }
            }
        }
        return fishes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        space = new int[N][N];
        Shark shark = new Shark();
        int time = 0;


        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                int input = sc.nextInt();
                space[i][j] = input;

                if(input == 9){
                    shark.x = i;
                    shark.y = j;
                    shark.size = 2;
                    shark.stack = 0;
                }

            }
        }

        while(true){
            List<Fish> fishes = canEat(shark);
            System.out.println(shark.x + " " + shark.y);
            System.out.println(fishes);

            if(fishes.size() == 0){
                break;
            }
            else if(fishes.size() == 1){
                shark.x = fishes.get(0).x;
                shark.y = fishes.get(0).y;
                shark.stack++;

                if(shark.stack == shark.size){
                    shark.size++;
                }
                space[shark.x][shark.y] = 0;
            }else{
                Collections.sort(fishes, Comparator.comparingInt((Fish f) -> f.dist).thenComparingInt(f-> f.x));
                    shark.x = fishes.get(0).x;
                    shark.y = fishes.get(0).y;
                    shark.stack++;

                    if(shark.stack == shark.size){
                        shark.size++;
                    }
                    space[shark.x][shark.y] = 0;
                }
            time++;
            System.out.println(shark);
        }
        System.out.println(time);

    }
}
