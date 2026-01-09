package BOJ_21775_가희와자원놀이;

import java.io.*;
import java.util.*;

public class Main {
    static class Card {
        int id;         // 카드 id (출력용)
        String op;      // "next" | "acquire" | "release"
        int n;          // 자원 번호 (next면 안씀)
        Card(int id, String op, int n) { this.id = id; this.op = op; this.n = n; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수 (크게 안씀)
        int T = Integer.parseInt(st.nextToken()); // 턴 수 == 카드 수

        // 턴 순서 T개
        Queue<Integer> turns = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) turns.add(Integer.parseInt(st.nextToken()));

        // 연산 카드 T장 (들어온 순으로 덱에 쌓임)
        Queue<Card> deck = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int cid = Integer.parseInt(st.nextToken()); // 카드 id
            String op = st.nextToken();
            int n = 0;
            if (!op.equals("next")) n = Integer.parseInt(st.nextToken());
            deck.add(new Card(cid, op, n));
        }

        // 상태
        Map<Integer, Card> hold = new HashMap<>(); // 플레이어 -> 보류 중 acquire 카드
        Set<Integer> taken = new HashSet<>();      // 점유 중 자원

        StringBuilder out = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int p = turns.poll(); // 이번 턴 플레이어

            Card cur = hold.get(p);
            if (cur != null) {
                // 보류 중인 acquire 재시도
                if (!taken.contains(cur.n)) {
                    taken.add(cur.n);
                    hold.remove(p);
                }
                out.append(cur.id).append('\n');
            } else {
                // 새 카드 뽑기
                Card c = deck.poll();
                if (c.op.equals("acquire")) {
                    if (taken.contains(c.n)) {
                        hold.put(p, c);  // 점유 중이면 보류
                    } else {
                        taken.add(c.n);  // 비어있으면 획득
                    }
                } else if (c.op.equals("release")) {
                    taken.remove(c.n);   // 반납 (대기자 자동 할당 X)
                }
                // next는 아무 것도 안함
                out.append(c.id).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}
