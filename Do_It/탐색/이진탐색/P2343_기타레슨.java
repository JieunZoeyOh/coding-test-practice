package Do_It.탐색.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * p.186
 * 문제 030. 블루레이 만들기
 * 백준 2343 [기타 레슨]
 */
public class P2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            start = Math.max(start, num);
            end += num;
        }

        br.close();

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                if (sum + num > mid) {
                    count++;
                    sum = 0;
                }
                sum += num;
            }
            if (sum != 0) {
                count++; // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요함
            }
            if (count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

}
