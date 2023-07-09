package Do_It.정수론.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * p. 217
 * 문제 037. 소수 구하기
 * 백준 1929 [소수 구하기]
 */
public class P1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        br.close();

        int[] arr = new int[end + 1];
        for (int i = start; i <= end; i++) {
            if (i == 1) {
                continue;
            }
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(end); i++) {
            int num = 2;
            while (i * num <= end) {
                arr[i * num] = 0;
                num++;
            }
        }

        for (int i = start; i <= end; i++) {
            int result = arr[i];
            if (result != 0) {
                System.out.println(result);
            }
        }
    }
}
