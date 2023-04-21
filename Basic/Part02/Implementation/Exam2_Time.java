package Basic.Part02.Implementation;

import java.util.Scanner;

/**
 * p. 113
 * 예제 4-2. 시각
 */
public class Exam2_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        sc.close();

        int total = (1 + hour) * 60 * 60;
        int except;
        if (hour < 3) {
            except = (1 + hour) * 5 * 9 * 5 * 9;
        } else if (hour < 13) {
            except = (hour) * 5 * 9 * 5 * 9;
        } else if (hour < 23) {
            except = (hour - 1) * 5 * 9 * 5 * 9;
        } else {
            except = (hour - 2) * 5 * 9 * 5 * 9;
        }

        System.out.println(total - except);

    }
}
