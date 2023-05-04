package Do_It;

import java.util.*;

/**
 * p. 81
 * 문제 011. 스택으로 오름차순 수열 만들기
 * 백준 1874 [스택 수열]
 * 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
 * push 연산은 +로, pop 연산은 -로 표현하도록 한다.
 * 불가능한 경우 NO를 출력한다.
 */
public class P1874_스택_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        boolean result = true;
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (num <= now) {
                while (num <= now) {
                    sb.append("+\n");
                    stack.push(num++);
                }
                sb.append("-\n");
                stack.pop();
            } else {
                int pop = stack.pop();
                if (pop > now) {
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
