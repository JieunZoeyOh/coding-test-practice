package Do_It.그리디;

import java.util.*;

/**
 * p. 203
 * 문제 034. 수를 묶어서 최대값 만들기
 * 백준 1744 [수 묶기]
 */
public class P1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else if (num > 1) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        int sum = 0;
        while (plus.size() > 1) {
            Integer first = plus.remove();
            Integer second = plus.remove();
            sum += (first * second);
        }
        if (plus.size() == 1) {
            Integer num = plus.remove();
            sum += num;
        }
        while (minus.size() > 1) {
            Integer first = minus.remove();
            Integer second = minus.remove();
            sum += (first * second);
        }
        if (minus.size() == 1) {
            if (zero == 0) {
                Integer num = minus.remove();
                sum += num;
            }
        }
        sum += one;

        System.out.println(sum);
    }
}
