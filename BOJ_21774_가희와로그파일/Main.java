package BOJ_21774_가희와로그파일;
import java.util.*;

public class Main {
    static int n,q;
    private static int lBound(List<String> arr, String start){
        int left = 0; int right = arr.size() - 1;
        int rt = arr.size();

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr.get(mid).compareTo(start) >= 0){
                rt = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return rt;
    }
    private static int uBound(List<String> arr, String end){
        int left = 0; int right = arr.size() - 1;
        int rt = arr.size();

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr.get(mid).compareTo(end) > 0){
                rt = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return rt;
    }
    private static void solution(String[] logs, String[] queries){
        List<String>[] levels = new ArrayList[7];
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 7; i++){
            levels[i] = new ArrayList<>();
        }
        for(String log : logs){
            StringBuilder sb = new StringBuilder();
            //0 date, 1 time#level
            String[] parse1 = log.split(" ");

            String[] parseDate = parse1[0].split("-");

            for(String pb : parseDate){
                sb.append(pb);
            }
            //dateStringBuilder

            //0 time, 1 level
            String[] timeLevels = parse1[1].split("#");
            String[] time = timeLevels[0].split(":");
            int level = Integer.parseInt(timeLevels[1]);

            //date+timeStringBuilder
            sb.append(timeLevels[0].replaceAll(":", ""));

            for (int i = 1; i <= level; i++) {
                levels[i].add(sb.toString());
            }
        }

        for(String query : queries){
            //0 start, 1 end, 2 level
            String[] parse1 = query.split("#");

            String start = parse1[0];
            String end = parse1[1];
            int level = Integer.parseInt(parse1[2]);

            String startDateTime = start.replaceAll("-", "").replaceAll(":","").replaceAll(" ", "");

            String endDateTime = end.replaceAll("-", "").replaceAll(":", "").replaceAll(" ","");
            List<String> arr = levels[level];

            int lower = lBound(arr, startDateTime);
            int upper = uBound(arr, endDateTime);


            ans.append( upper - lower).append('\n');

        }
        System.out.println(ans.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        sc.nextLine();
        String[] logs = new String[n];
        String[] queries = new String[q];
        for(int i = 0 ; i < n; i++){
            logs[i] = sc.nextLine();
        }

        for(int i = 0 ; i < q; i++){
            queries[i] = sc.nextLine();
        }
        solution(logs,queries);
    }

}
