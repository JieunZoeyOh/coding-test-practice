package Do_It.정수론.유클리드호제법;

import java.io.*;
import java.util.StringTokenizer;

/**
 * p. 237
 * 문제 042. 최소 공배수 구하기
 * 백준 1934 [최소공배수]
 */
public class P1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcb = a > b ? gcb(a, b) : gcb(b, a);
            bw.write(a * b / gcb + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcb(int a, int b) {
        if (b == 0)  {
            return a;
        }
        return gcb(b, a % b);
    }
}
