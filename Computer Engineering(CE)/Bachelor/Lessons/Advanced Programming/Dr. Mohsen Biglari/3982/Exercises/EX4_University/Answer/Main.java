import java.util.Scanner;
public class Main {
    public static int s = 0;
    public static int[] ar2 = new int[500];
    public static int[] l = new int[500];
    public static int[] o = new int[500];
    public static int over = 0;
    static class Student {
        private String fName = "";
        private String lName = "";
        private int noOfCourse = 0;
        private double scores = 0;
        private double average = 0;
        private int semester = 0;
        private static int numOfStudents = 1;
        int id;
        public String getfName() {
            return fName;
        }
        public void setfName(String fName) {
            this.fName = fName;
        }
        public String getlName() {
            return lName;
        }
        public void setlName(String lName) {
            this.lName = lName;
            this.id = numOfStudents++;
        }
        public int getNoOfCourse() {
            return noOfCourse;
        }
        public void setNoOfCourse(int noOfCourse) {
            this.noOfCourse = noOfCourse;
        }
        public double getScores() {
            return scores;
        }
        public void setScores(double scores) {
            this.scores = scores;
        }
        public int getSemester() {
            return semester;
        }
        public void setSemester(int semester) {
            this.semester = semester;
        }
        public int getId() {
            return id;
        }
        public double getAverage() {
            return average;
        }
        public void setAverage(double average) {
            this.average = average;
        }
        public void computingAverage() {
            setAverage((double) getScores() / getNoOfCourse());
        }
        public void printStudent() {
            System.out.printf("Added: %d%n", id);
        }
        public void printStudent2() {
            System.out.printf("Id: %d, %s %s: Semester: %d - Average: %.2f\n", id, getfName(), getlName(), semester, getAverage());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int u = 1;
        University university;
        university = new University();
        while (in.hasNext()) {
            String order = in.next();
            if (order.charAt(0) == 97) {
                Student student;
                student = new Student();
                student.setfName(in.next());
                student.setlName(in.next());
                student.setSemester(in.nextInt());
                int m = in.nextInt(), noOfCourse = 0;
                double score = 0;
                for (int j = 0; j < m; j++) {
                    int tempNuberCourse = in.nextInt();
                    noOfCourse += tempNuberCourse;
                    score += in.nextDouble() * tempNuberCourse;
                }
                student.setNoOfCourse(noOfCourse);
                student.setScores(score);
                student.computingAverage();
                s++;
                university.add(student);

            }
            if (order.charAt(0) == 112) {
                Student student;
                university.print();
            }
            if (order.charAt(0) == 111) {
                Student student;
                university.Overall();
            }
            if (order.charAt(0) == 114) {
                Student student;
                String remove = in.next();
                university.remove(remove);
            }
            if (order.charAt(0) == 99) {
                university.count();
            }
            if (order.charAt(0) == 115) {
                    String search = in.next();
                    if(search.charAt(0) < 58 && search.charAt(0) > 46){
                        university.search1(Double.parseDouble(search));
                    }else
                    university.search(search);

            }
        }

    }

    static class University {
        static Student ar[] = new Student[500];
        static int i = 1;

        static void add(Student student) {
            ar[s] = student;
            i++;
            over++;
            for (int j = 1; j <= s; j++) {
                if (ar[j].id != l[j]) {

                    if (o[j] != ar[j].id) {
                        o[j] = ar[j].id;
                        ar[j].printStudent();
                    }
                }
            }
        }

        public void print() {

            for (int j = 1; j <= s; j++) {
                if (ar[j].id != l[j]) {
                    ar[j].printStudent2();
                }
            }
        }

        public void Overall() {
            float ov = 0;
            for (int j = 1; j <= s; j++) {
                ov += ar[j].average;
            }
            System.out.printf("Overall average: ");
            if ((ov / over) > 0) {
                System.out.printf("%.2f\n", ov / over);
            } else {
                System.out.println("0.00");
            }
        }

        public void remove(String remove) {
            int q = 0;
            int x = 0;
            System.out.printf("Removed:");
            for (int j = s; j >= 1; j--) {
                if (ar[j].lName.length() == remove.length()) {
                    for (int i = 0; i < ar[j].lName.length(); i++) {
                        if (ar[j].lName.charAt(i) == remove.charAt(i)) {
                            q++;
                        }
                }
                    if (q == remove.length()) {
                        l[j] = ar[j].id;
                            System.out.printf(" " + ar[j].id) ;
                        q = 0;
                        x++;
                        ar[j].average = 0;
                        over--;


                }
                    q=0;
            }


                }
                System.out.println();

        }

        public void count() {
            System.out.println("Number of students: " + over);
        }

        public void search(String search) {
            int q = 0;
            int x = 0;
            System.out.println("Searched:");
            if (s == 0) {
               // System.out.println("Searched: ");
            }
            for (int j = s; j >= 1; j--) {
                if (search.length() == ar[j].lName.length()) {
                    //   System.out.println("Searched: ");
                    for (int i = 0; i < ar[j].lName.length(); i++) {
                        if (ar[j].lName.charAt(i) == search.charAt(i)) {
                            q++;
                        }
                        if (q == search.length()) {
                            ar2[j] = ar[j].id;
                            ar[j].printStudent2();
                            x++;
                            q = 0;
                        }
                    }
                }


               /* if (x == 0) {
                    System.out.println("Searched: ");
                }*/

            }
        }

        public void search1(double search1) {
            int x = 0;
            int z = 0;
            System.out.println("Searched:");
            if (s == 0) {
                //System.out.println("Searched: ");
            }
            for (int j = 1; j <= s; j++) {
                if (search1 > ar[j].average) {
                }
                if (search1 <= ar[j].average) {
                    //System.out.println("Searched: ");
                    ar[j].printStudent2();
                    x++;
                }
              /*  if(x==0 && z==0){
                    System.out.println("Searched: ");
                    z++;
                }*/
            }
        }
    }
}