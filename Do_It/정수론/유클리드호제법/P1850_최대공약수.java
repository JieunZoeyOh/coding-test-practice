package Do_It.정수론.유클리드호제법;

import java.io.*;
import java.util.StringTokenizer;

/**
 * p. 240
 * 문제 043. 최대 공약수 구하기
 * 백준 1850 [최대공약수]
 */
public class P1850_최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcb = a > b ? gcb(a, b) : gcb(b, a);
        for (long i = 0; i < gcb; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    private static long gcb(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcb(b, a % b);
    }
}
