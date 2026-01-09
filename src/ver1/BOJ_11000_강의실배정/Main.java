package BOJ_11000_강의실배정;
import java.util.*;

public class Main {
    public static class Lecture{
        int start;
        int end;

        public Lecture(int a, int b){
            this.start = a;
            this. end = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            lectures.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }

        HashMap<Integer, Integer> a = new HashMap<>();

        Collections.sort(lectures, (s1, s2) ->  s1.start - s2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Lecture lecture : lectures){
            if(!pq.isEmpty()&& pq.peek() <= lecture.start){
                pq.poll();
            }
            pq.offer(lecture.end);
        }
        System.out.println(pq.size());
    }
}
