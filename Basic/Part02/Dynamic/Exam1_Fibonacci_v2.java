package Basic.Part02.Dynamic;

/**
 * p. 215
 * 피보나치 수열 보텀업 방식
 * 보텀업 방식: 단순히 반복문을 이용하여 작은 문제부터 차근차근 답을 도출하는 방식
 */
public class Exam1_Fibonacci_v2 {

    public static void main(String[] args) {
        long[] d = new long[100];
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        // 피보나치 함수를 반복문으로 구현(보텀업 다이나믹 프로그래밍)
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + " ");
        }
    }
}
