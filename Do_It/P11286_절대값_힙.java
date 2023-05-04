package Do_It;

import java.io.*;
import java.util.*;

/**
 * p. 94
 * 문제 014. 절대값 힙 구현하기
 * 백준 11286 [절대값 힙]
 */
public class P11286_절대값_힙 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 - o2;
            } else {
                return firstAbs - secondAbs;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                Integer p = pq.poll();
                bw.write(p == null ? "0" : String.valueOf(p));
                bw.write("\n");
            } else {
                pq.offer(num);
            }
        }
        sc.close();

        bw.flush();
        bw.close();
    }
}
