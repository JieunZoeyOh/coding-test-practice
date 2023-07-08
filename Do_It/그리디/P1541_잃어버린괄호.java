package Do_It.그리디;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * p. 211
 * 문제 036. 최솟값을 만드는 괄호 배치 찾기
 * 백준 1541 [잃어버린 괄호]
 */
public class P1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String question = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(question, "-");

        boolean isFirst = true;
        int result = 0;
        while (st.hasMoreTokens()) {
            String part = st.nextToken();
            int sumResult = sum(part);
            if (isFirst) {
                result += sumResult;
                isFirst = false;
            } else {
                result -= sumResult;
            }
        }

        System.out.println(result);
    }

    private static int sum(String part) {
        int result = 0;
        StringTokenizer st = new StringTokenizer(part, "+");
        while (st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}
