package BOJ_2170_선긋기;

import java.util.*;

public class Main {

    public static List<int[]> sortList(List<int[]> list){

        list.sort((a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);

        });

        return list;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> lines = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            lines.add(new int[]{start, end});
        }

        sortList(lines);

        int startPoint = lines.get(0)[0];
        int endPoint = lines.get(0)[1];

        int lineLength = 0;

        for (int i = 1; i < lines.size(); i++) {
            int newStartPoint = lines.get(i)[0];
            int newEndPoint = lines.get(i)[1];

            if (newStartPoint <= endPoint) {
                endPoint = Math.max(endPoint, newEndPoint);
            } else {
                lineLength += endPoint - startPoint;

                startPoint = newStartPoint;
                endPoint = newEndPoint;
            }
        }
        lineLength += endPoint - startPoint;

        System.out.println(lineLength);
    }
}
/*
package BOJ_2170_선긋기;

import java.io.*;
import java.util.*;

public class Main {

    public static List<int[]> sortList(List<int[]> list) {
        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        return list;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new int[]{start, end});
        }

        sortList(lines);

        int startPoint = lines.get(0)[0];
        int endPoint = lines.get(0)[1];
        int lineLength = 0;

        for (int i = 1; i < lines.size(); i++) {
            int newStartPoint = lines.get(i)[0];
            int newEndPoint = lines.get(i)[1];

            if (newStartPoint <= endPoint) {
                endPoint = Math.max(endPoint, newEndPoint);
            } else {
                lineLength += endPoint - startPoint;
                startPoint = newStartPoint;
                endPoint = newEndPoint;
            }
        }

        lineLength += endPoint - startPoint;

        bw.write(lineLength + "\n");
        bw.flush();
    }
}

 */