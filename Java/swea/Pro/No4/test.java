package swea.Pro.No4;

import java.util.*;

public class test {

    public static class CustomComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            // gender (male, female 순서)
            if(o1.gender == 1 && o2.gender == 2) return -1;
            else if(o1.gender == 2 && o2.gender == 1) return 1;
            else {
                // grade (오름차순)
                if(o1.grade > o2.grade) return 1;
                else if(o1.grade < o2.grade) return -1;
                else {
                    // score (오름차순)
                    if(o1.score != o2.score) return o1.score - o2.score;
                    // id (오름차순)
                    else return o1.id - o2.id;
                }
            }
        }
    }


    public static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void main(String[] args) {

    }

    /*
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>(new CustomComparator());
//        TreeSet<Student> set = new TreeSet<>(new IdComparator());

        set.add(new Student(2, 1, 100, 10));
        set.add(new Student(2, 2, 100, 100));
        set.add(new Student(2, 3, 100, 12));
        set.add(new Student(2, 3, 200, 14));
        set.add(new Student(1, 1, 100, 20));
        set.add(new Student(1, 1, 100, 30));
        set.add(new Student(1, 1, 70, 40));
        set.add(new Student(1, 1, 70, 35));
        set.add(new Student(1, 1, 80, 50));
        set.add(new Student(1, 1, 90, 60));
        set.add(new Student(1, 1, 100, 70));

        // 삭제 전
//        for (Student student : set) System.out.println(student);
//        System.out.println();

        // id 기준 재정렬
        TreeSet<Student> tempSet = new TreeSet<>(new IdComparator());
        tempSet.addAll(set);

        for (Student student : tempSet) System.out.println(student);
        System.out.println();

        // 삭제
        tempSet.remove(new Student(14));

        // 삭제할 객체 가져오기
        Student floor = tempSet.floor(new Student(13));
        System.out.println(floor);

        // 삭제 후
//        for (Student student : tempSet) System.out.println(student);
//        System.out.println();
    }
*/
    public static class Student {
        int gender, grade, score, id;

        public Student(int gender, int grade, int score, int id) {
            this.gender = gender;
            this.grade = grade;
            this.score = score;
            this.id = id;
        }

        public Student(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "gender=" + gender +
                    ", grade=" + grade +
                    ", score=" + score +
                    ", id=" + id +
                    '}';
        }
    }
}
