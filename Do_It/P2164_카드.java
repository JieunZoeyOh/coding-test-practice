package Do_It;

import java.util.*;

/**
 * p. 91
 * 문제 013. 카드게임
 * 백준 2164 [카드2]
 */
public class P2164_카드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }

        Integer card = q.poll();
        System.out.println(card);
    }
}
