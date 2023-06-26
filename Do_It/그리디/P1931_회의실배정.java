package Do_It.그리디;

import java.util.Arrays;
import java.util.Scanner;

/**
 * p. 207
 * 문제 035. 회의실 배정하기
 * 백준 1931 [회의실 배정]
 */
public class P1931_회의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        Arrays.sort(meetings, (int[] s, int[] e) -> {
            if (s[1] == e[1]) { // 종료 시간이 같을 경우 시작 시간을 기준으로 정렬
                return s[0] - e[0];
            }
            // 종료 시간 순으로 정렬
            return s[1] - e[1];
        });

        int count = 0;
        int end = -1; // 회의 종료 시간
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= end) {
                count += 1;
                end = meetings[i][1]; // 회의 종료 시간 업데이트
            }
        }

        System.out.println(count);
    }
}
