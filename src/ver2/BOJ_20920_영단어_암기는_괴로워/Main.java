package ver2.BOJ_20920_영단어_암기는_괴로워;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String st = sc.next();

            if(st.length() < m ) continue;

            map.put(st,map.getOrDefault(st,0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b) -> {
            if(a.getValue() != b.getValue()){
                return b.getValue() - a.getValue();
            }
            else if(a.getKey().length()!= b.getKey().length()){
                return b.getKey().length() - a.getKey().length();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i).getKey());
        }
    }
}

/*
# 카테고리
Hash Map

# 접근 방식
Hash map에 빈도수를 저장하고 빈도수를 정렬해서 해결하였다.

# 문제 링크
https://www.acmicpc.net/problem/20920
 */