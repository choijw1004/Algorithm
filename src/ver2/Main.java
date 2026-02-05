package ver2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room{
    int id;
    int standard;
    int count;

    public Room(int id, int standard, int count){
        this.id = id;
        this.standard = standard;
        this.count = count;
    }

    public void upCount(){
        this.count++;
    }
}

class Player{
    String name;
    int level;

    public Player(String name, int level){
        this.name = name;
        this.level = level;
    }
}

public class Main {
    static int n,m;
    static List<Player> players;
    static List<Room> rooms;

    private static int findRoom(int level){
        int id = -1;

        for(int i = 0 ; i < rooms.size(); i++){
            int standard = rooms.get(i).standard;

            if(Math.abs(standard - level) <= 10 && rooms.get(i).count < m){
                id = i;
                return id;
            }
        }

        return id;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        players = new ArrayList<>();
        rooms = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int newPlyaerLevel = sc.nextInt();
            String newPlayerName = sc.next();

            Player newPlayer = new Player(newPlayerName, newPlyaerLevel);

            int flag = findRoom(newPlyaerLevel);
            //방 없음
            if(flag == -1){
                System.out.println("Waiting!");
                System.out.println("Started!");
                Room newRoom = new Room(rooms.size() + 1, m, 1);
                rooms.add(newRoom);
                players.add(newPlayer);
            }

            //방 있음
            else{
                Room currentRoom = rooms.get(flag);
                currentRoom.upCount();
                players.add(newPlayer);
            }
        }
    }

}

/*
# 카테고리
구현

# 접근 방식
평범한 구현 문제이다.

# 문제 링크
https://www.acmicpc.net/problem/20006
 */