package Do_It.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * p. 199
 * 문제 033. 카드 정렬하기
 * 백준 1715 [카드 정렬하기]
 */
public class P1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }

        int result = 0;

        while (q.size() > 1) {
            Integer i1 = q.poll();
            Integer i2 = q.poll();
            int sum = i1 + i2;
            result += sum;
            q.offer(sum);
        }

        System.out.println(result);
    }
}
