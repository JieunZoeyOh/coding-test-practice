package Do_It.정수론.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * p. 227
 * 문제 040. 제곱이 아닌 수 찾기
 * 백준 1016 [제곱 ㄴㄴ 수]
 */
public class P1016_제곱이_아닌_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        br.close();

        boolean[] arr = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;

            for (long startIndex = (pow - (min % pow)) % pow; startIndex <= max - min; startIndex += pow) {
                arr[(int) startIndex] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
