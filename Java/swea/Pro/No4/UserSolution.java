package swea.Pro.No4;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

class UserSolution {
    private TreeSet<Student> students;
    private TreeMap<Integer, Student> Ids;

    public class CustomComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            // gender
            if(o1.gender != o2.gender) return o1.gender - o2.gender;

            // grade
            if(o1.grade != o2.grade) return o1.grade - o2.grade;

            // score
            if(o1.score != o2.score) return o1.score - o2.score;

            // id
            return o1.id - o2.id;
        }
    }

    public void init() {
        students = new TreeSet<>(new CustomComparator());
        Ids = new TreeMap<>();
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        // 학생 정보
        int gender = mGender[0] == 'm' ? 1 : 2;
        Student student = new Student(gender, mGrade, mScore, mId);

        // 추가
        students.add(student);
        Ids.put(mId, student);

        // mGrade학년 mGender인 학생 중에서 점수가 가장 높은 학생의 ID를 반환
        // gender grade
        // 1        1
        // 1        2
        // 1        3
        // 2        1
        // 2        2
        // 2        3
        Student temp_st = new Student(gender, mGrade+1, 0, 0);
        Student lower = students.lower(temp_st);
        return lower.id;
    }

    public int remove(int mId) {
        // 학생 정보
        Student removed = Ids.get(mId);

        // mId 학생의 점수가 기록되어 있지 않다면 0을 반환
        if(removed == null) return 0;

        // 삭제
        students.remove(removed);

        // mId 학생의 학년과 성별이 동일한 학생 중에서 점수가 가장 낮은 학생의 ID를 반환
        Student higher = students.higher(new Student(removed.gender, removed.grade, 0, 0));

        if(higher == null || higher.gender != removed.gender || higher.grade != removed.grade)
            return 0;

        return higher.id;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        Student lowest = new Student(mGender[0][0] == 'm' ? 1 : 2, mGrade[0], 300001);

        // 반복 횟수 최대 6 (= 2 * 3)
        for (int i = 0; i < mGenderCnt; i++) {
            int gender = mGender[i][0] == 'm' ? 1 : 2;

            for (int j = 0; j < mGradeCnt; j++) {
                Student temp_st = new Student(gender,mGrade[j], mScore);
                Student higher = students.higher(temp_st);

                if(higher == null || temp_st.gender != higher.gender || temp_st.grade != higher.grade)
                    continue;

                if(higher.score < lowest.score) lowest = higher;
                else if(higher.score == lowest.score) {
                    if(higher.id < lowest.id) lowest = higher;
                }
            }
        }

        if(lowest.score == 300001) return 0;
        return lowest.id;
    }

    public class Student {
        int gender, grade, score, id;

        public Student(int gender, int grade, int score, int id) {
            this.gender = gender;
            this.grade = grade;
            this.score = score;
            this.id = id;
        }

        public Student(int gender, int grade, int score) {
            this.gender = gender;
            this.grade = grade;
            this.score = score;
        }
    }
}