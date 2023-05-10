package Do_It.탐색.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * p.182
 * 문제 029. 원하는 정수 찾기
 * 백준 1920 [수 찾기]
 */
public class P1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean result = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int midValue = arr[mid];
                if (midValue > target) {
                    end = mid - 1;
                } else if (midValue < target) {
                    start = mid + 1;
                } else {
                    result = true;
                    break;
                }
            }

            bw.write(result ? "1\n" : "0\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
