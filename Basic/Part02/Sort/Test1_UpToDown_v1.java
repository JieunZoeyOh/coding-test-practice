package Basic.Part02.Sort;

import java.util.*;

/**
 * p. 178
 * 위에서 아래로
 * 하나의 수열에는 다양한 수가 존재한다. 이러한 수는 크기에 상관없이 나열되어 있다.
 * 이 수를 큰 수부터 작은 수의 순서로 정렬해야 한다.
 * 수열을 내림차순으로 정렬하는 프로그램을 만드시오
 * 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다 (1 <= N <= 500)
 * 둘째 줄부터 N + 1번째 줄까지 N개의 수가 입력된다. (1 <= x <= 100,000)
 */
public class Test1_UpToDown_v1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        int[] x = new int[100_001];
        for (int ele: arr) {
            x[ele] += 1;
        }

        for (int i = 100000; i > 0; i--) {
            for (int j = 0; j < x[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
