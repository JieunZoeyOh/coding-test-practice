package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 63
 * 문제 008. '좋은 수' 구하기
 * 백준 1253 [좋다]
 */
public class P1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 주어진 N개의 수
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int find = arr[i];
            int a = 0, b = n - 1;

            while (a < b) {
                int sum = arr[a] + arr[b];
                if (sum == find) {
                    // a와 b는 i가 아니어야 한다. 0이 있을 수도 있으므로
                    if (a != i && b != i) {
                        count++;
                        break;
                    } else if (a == i) {
                        a++;
                    } else {
                        b--;
                    }
                } else if (sum < find) {
                    a++;
                } else {
                    b--;
                }
            }
        }

        System.out.println(count);
    }
}
