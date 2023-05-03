package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 59
 * 문제 007. 주몽의 명령
 * 백준 1940 [주몽]
 */
public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 재료의 개수

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 갑옷이 완성되는 번호의 합

        st = new StringTokenizer(br.readLine());

        int[] materials = new int[n];

        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        Arrays.sort(materials);

        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int sum = materials[start] + materials[end];
            if (sum == m) {
                count++;
                start++;
                end--;
            } else if (sum < m) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}
