package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 86
 * 문제 012. 오큰수 구하기
 * 백준 17298 [오큰수]
 */
public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answers[i] = -1;
        }
        br.close();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            while (!stack.empty() && now > arr[stack.peek()]) {
                int idx = stack.pop();
                answers[idx] = now;
            }
            stack.push(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int answer : answers) {
            bw.write(answer + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
