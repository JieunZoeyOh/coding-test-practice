package Basic.Part02.DFS_BFS;

/**
 * p. 132
 * 팩토리얼 재귀함수 예제
 */
public class Exam1 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int num) {
        if (num <= 1) return 1;
        return num * f(num - 1);
    }
}
