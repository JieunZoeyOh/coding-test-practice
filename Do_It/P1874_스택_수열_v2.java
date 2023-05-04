package Do_It;

import java.util.*;
import java.io.*;

/**
 * p. 81
 * 문제 011. 스택으로 오름차순 수열 만들기
 * 백준 1874 [스택 수열]
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
 * push 연산은 +로, pop 연산은 -로 표현하도록 한다.
 * 불가능한 경우 NO를 출력한다.
 */
public class P1874_스택_수열_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        int idx = 0;
        while (num <= n) {
            stack.push(num);
            sb.append('+').append('\n');
            num++;

            while (!stack.empty() && (stack.peek() == numbers[idx])) {
                idx++;
                stack.pop();
                sb.append('-').append('\n');
            }
        }

        System.out.println(stack.isEmpty() ? sb : "NO");
    }
}
