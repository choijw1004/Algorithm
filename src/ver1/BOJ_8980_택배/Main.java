package BOJ_8980_택배;
import java.util.*;
class Job{
    int start,end,boxes;
    public Job(int start, int end, int boxes){
        this.start = start;
        this.end = end;
        this. boxes = boxes;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxCapacity = sc.nextInt();
        int jobs = sc.nextInt();
        List<Job> list = new ArrayList<>();
        int ans = 0;

        for(int i = 0 ; i < jobs; i++){
            Job job = new Job(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Collections.sort(list,(a,b) ->{
            if(a.start != b.start) return a.start - b.start;
            else return a.end - b.end;
        });

        
    }
}
