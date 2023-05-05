package Do_It.정렬;

import java.io.*;

/**
 * p. 139
 * 문제 022. 수 정렬하기3
 * 백준 10989 [수 정렬하기]
 */
public class P10989_수_정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10_001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            for (int j = 0; j < count; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
