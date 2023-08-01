import java.util.Scanner;

class Student {

    private String firstName = "";
    private String lastName = "";
    private int lessonNumbers = 0;
    private int unit[] = new int[lessonNumbers];
    private double score[] = new double[lessonNumbers];

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLessonNumbers() {
        return lessonNumbers;
    }

    public void setLessonNumbers(int lessonNumbers) {
        this.lessonNumbers = lessonNumbers;
    }

    public int getUnit(int i) {
        return unit[i];
    }

    public void setUnit(int[] unit) {
        this.unit = unit;
    }

    public double getScore(int i) {
        return score[i];
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public double average(int[] a , double[] b) {
        double avg = 0;

        for (int i = 0; i < a.length; i++) {
            avg += a[i] * b[i];
        }

        return avg;
    }

}


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] student = new Student[n];

        for (int i = 0; i < n; i++) {
            Student temp = new Student();
            temp.setFirstName(scanner.next());
            temp.setLastName(scanner.next());
            int m = scanner.nextInt();
            temp.setLessonNumbers(m);
            double average = 0;
            int units = 0;
            int unit[] = new int[m];
            double score[] = new double[m];
            for (int j = 0; j < temp.getLessonNumbers(); j++) {
                    unit[j]=scanner.nextInt();
                    score[j]=scanner.nextDouble();
                    units+=unit[j];
            }
            temp.setUnit(unit); 
            temp.setScore(score);
            student[i] = temp;

            System.out.printf("%s %s: %.2f\n",student[i].getFirstName(),student[i].getLastName(),student[i].average(unit,score)/units);
        }

    }
}