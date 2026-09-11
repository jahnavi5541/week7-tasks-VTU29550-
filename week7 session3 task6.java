import java.util.*;

public class Solution {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                result.add(grade);
            } else {
                int nextMultiple = ((grade / 5) + 1) * 5;

                if (nextMultiple - grade < 3) {
                    result.add(nextMultiple);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        List<Integer> result = gradingStudents(grades);

        for (int grade : result) {
            System.out.println(grade);
        }

        sc.close();
    }
}


OUTPUT:

Input (stdin)
4
73
67
38
33
Your Output (stdout)
75
67
40
33
Expected Output
75
67
40
33
