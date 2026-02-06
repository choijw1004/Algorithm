//package ver2.BOJ_거짓말;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    static int n,m;
//    static List<Integer>[] graph;
//
//    private static int find(int x){
//        if(parent[x] != x){
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//    private static void union(int x, int y){
//        int rootX = find(x);
//        int rootY = find(y);
//
//        if(rootX != rootY) parent[rootX] = parent[rootY];
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        int c = sc.nextInt();
//        graph = new ArrayList[n+1];
//
//        for(int i = 0 ; i <= n ;i++){
//            graph[i] = new ArrayList<>();
//        }
//
//        int[] knows = new int[c];
//
//        if(c != 0){
//            for(int i = 0 ; i < c; i++){
//                knows[i] = sc.nextInt();
//            }
//        }
//
//        for(int i = 0 ; i < m; i++){
//        }
//
//    }
//}
