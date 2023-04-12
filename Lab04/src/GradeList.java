import java.util.ArrayList;
import java.util.Collections;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<>();
    public GradeList() {
    }
    public void addGrade(double newGrade){
        grades.add(newGrade);
    }
    public double averageGrade(){
            double sumOfAllGrades = 0;
        for (Double grade : grades) {
            sumOfAllGrades = sumOfAllGrades + grade;
        }
            return sumOfAllGrades/grades.size();
    }

    public double maxGrade(){
            return Collections.max(grades);
    }

    public double minGrade(){
            return Collections.min(grades);
    }

    public boolean isEmpty(){
        return grades.size() != 0;
    }
}



