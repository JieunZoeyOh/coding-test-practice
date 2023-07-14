package Do_It.정수론.소수구하기;

import java.util.Scanner;

/**
 * p. 224
 * 문제 039. 소수&팰린드롬 수 중에서 최솟값 찾기
 * 백준 1747 [소수 & 팰린드롬]
 */
public class P1747_소수_팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] arr = new int[10_000_001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        int index = n;
        while (true) {
            if (arr[index] == 0) {
                index++;
                continue;
            }

            if (isPalindrome(arr[index])) {
                System.out.println(arr[index]);
                break;
            }
            index++;
        }
    }

    private static boolean isPalindrome(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
