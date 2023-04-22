package Basic.Part02.Sort;

import java.util.*;

/**
 * p. 180
 * 성적이 낮은 순서로 학생 출력하기
 * 첫 번째 줄에 학생의 수 N이 입력된다. (1 <= N <= 100_000)
 * 두 번째 줄부터 N + 1번째 줄에는 학생의 이름을 나타내는 문자열 A와
 * 학생의 성적을 나타내는 정수 B가 공백으로 구분되어 입력된다.
 * 문자열 A의 길이와 학생의 성적은 100 이하의 자연수이다.
 * 모든 학생의 이름을 성적이 낮은 순서대로 출력한다.
 */
public class Test2_Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }
        sc.close();

        Collections.sort(students);

        for (Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        // 정렬 기준은 '점수가 낮은 순서'
        @Override
        public int compareTo(Student o) {
            return this.score - o.score;
        }
    }
}
