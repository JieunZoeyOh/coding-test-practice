package Basic.Part02.BinarySearch;

import java.util.Scanner;

/**
 * p. 197
 * 부품 찾기
 * 계수 정렬을 통해 문제 해결
 */
public class Exam3_FindPart_CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] nArr = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            nArr[sc.nextInt()] = 1;
        }

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int item = sc.nextInt();
            if (nArr[item] == 1) {
                System.out.print("YES ");
            } else {
                System.out.print("NO ");
            }
        }

        sc.close();

    }

}
