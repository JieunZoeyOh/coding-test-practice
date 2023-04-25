package Basic.Part02.Dynamic;

/**
 * p.214
 * 피보나치 수열 탑다운 방식
 * 탑다운 방식, 하향식: 큰 문제를 해결하기 위해 작은 문제를 재귀적으로 호출하는 방식
 */
public class Exam1_Fibonacci_v1 {
    static int[] d = new int[100];

    public static void main(String[] args) {
        System.out.println("result: " + fibonacci(11));

    }

    private static int fibonacci(int x) {
        System.out.print("f(" + x + ") ");
        if (x == 1 || x == 2) {
            return 1;
        }
        if (d[x] != 0) {
            return d[x];
        }
        d[x] = fibonacci(x - 1) + fibonacci(x - 2);
        return d[x];
    }
}
