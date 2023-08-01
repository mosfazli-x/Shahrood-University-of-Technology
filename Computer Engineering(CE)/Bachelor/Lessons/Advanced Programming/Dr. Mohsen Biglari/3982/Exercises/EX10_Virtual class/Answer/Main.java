import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int CountOfSessions = 0, NumofSession = 0 , u = 0 , t = 0 , k = 0;
    public static double ScoreOfSession, ScoreOfPositives;
    public static Student[] students = new Student[500];

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        CountOfSessions = scanner.nextInt();
        ScoreOfSession = scanner.nextDouble();
        ScoreOfPositives = scanner.nextDouble();

        String[] command = new String[3];
        String s = new String();
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            command = s.split(" ");
            u = command.length;
            t++;
            int flag = 0 , flag2 = 0 , flag3 = 0 , flag4 = 0;
            if (t > 1) {
                switch (u) {
                    case 1: {
                        if (command[0].charAt(0) >= 48 && command[0].charAt(0) <= 57) {
                            NumofSession = Integer.parseInt(command[0]);
                            break;
                        } else {
                            for (int i = 0; i < k; i++) {
                                if (students[i].Name.contains(command[0].toLowerCase())) {
                                    students[i].CountSessions++;
                                    flag4 = 1;
                                    break;
                                }
                            }
                            if (flag4 == 0) {
                                Student temp = new Student();
                                temp.Name.add(command[0].toLowerCase());
                                temp.CountSessions++;
                                students[k] = temp;
                                k++;
                                break;
                            }
                            break;
                        }

                    }

                    case 2: {
                        if (command[1].contains("+") || command[1].contains("-")) {
                            for (int i = 0; i < k; i++) {
                                if (students[i].Name.contains(command[0].toLowerCase())) {
                                    students[i].CountSessions++;
                                    flag = 1;
                                    for (int j = 0; j < command[1].length(); j++) {
                                        if (command[1].charAt(j) == '+') {
                                            students[i].Score += 1 * ScoreOfPositives;
                                        }
                                        if (command[1].charAt(j) == '-') {
                                            students[i].Score -= 1 * ScoreOfPositives;
                                        }
                                    }
                                    break;
                                }

                            }

                            if (flag == 0) {
                                Student temp = new Student();
                                temp.Name.add(command[0].toLowerCase());
                                temp.CountSessions++;
                                for (int j = 0; j < command[1].length(); j++) {
                                    if (command[1].charAt(j) == '+') {
                                        temp.Score += ScoreOfPositives;
                                    }
                                    if (command[1].charAt(j) == '-') {
                                        temp.Score -= ScoreOfPositives;
                                    }
                                }
                                students[k] = temp;
                                k++;
                                break;
                            }
                            break;
                        } else {
                            for (int i = 0; i < k; i++) {
                                if (t > 2) {
                                    if (students[i].Name.contains(command[0].toLowerCase())) {
                                        students[i].CountSessions++;
                                        students[i].Name.add(command[1].toLowerCase());
                                        flag3 = 1;
                                        break;
                                    }
                                }
                                if (t == 2) {
                                    Student temp = new Student();
                                    temp.CountSessions++;
                                    temp.Name.add(command[0].toLowerCase());
                                    temp.Name.add(command[1].toLowerCase());
                                    students[k] = temp;
                                    k++;
                                    flag3 = 1;
                                    break;
                                }

                            }
                            if (flag3 == 0) {
                                Student temp = new Student();
                                temp.CountSessions++;
                                temp.Name.add(command[0].toLowerCase());
                                temp.Name.add(command[1].toLowerCase());
                                students[k] = temp;
                                k++;
                                break;
                            }
                            break;
                        }


                    }

                    case 3: {
                        for (int i = 0; i < k; i++) {
                            if (students[i].Name.contains(command[0].toLowerCase())) {
                                students[i].Name.add(command[1].toLowerCase());
                                students[i].CountSessions++;
                                flag2 = 1;
                                for (int j = 0; j < command[2].length(); j++) {
                                    if (command[2].charAt(j) == '+') {
                                        students[i].Score += ScoreOfPositives;
                                    }
                                    if (command[2].charAt(j) == '-') {
                                        students[i].Score -= ScoreOfPositives;
                                    }
                                }
                            }
                        }
                        if (flag2 == 0) {
                            Student temp = new Student();
                            temp.Name.add(command[0].toLowerCase());
                            temp.Name.add(command[1].toLowerCase());
                            temp.CountSessions++;
                            flag2 = 1;
                            for (int j = 0; j < command[2].length(); j++) {
                                if (command[2].charAt(j) == '+') {
                                    temp.Score += ScoreOfPositives;
                                }
                                if (command[2].charAt(j) == '-') {
                                    temp.Score -= ScoreOfPositives;
                                }
                            }
                            students[k] = temp;
                            k++;
                            break;
                        }
                        break;
                    }

                }
            }

        }

        for (int i = 0; i < k; i++) {
            double d = ScoreOfSession * (students[i].CountSessions / CountOfSessions);
            String str = String.format("%f", d);
            students[i].Score += Double.parseDouble(str);
            students[i].Score = (double) ((int) ((students[i].Score * 100) + 0.5)) / 100;
            if (students[i].Score <= 0) {
                students[i].Score = 0;
            }if(students[i].Score >= 20){
                students[i].Score = 20;
            }


        }

        for (int i = 0; i < k ; i++) {
            for (int j = 0; j < k - 1; j++) {
                String str = String.format("%.2f", students[j].Score);
                students[j].Score = Double.parseDouble(str);
                if (students[j].Score > students[j + 1].Score) {
                    Student temp = new Student();
                    temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
                if (students[j].Score == students[j + 1].Score && students[j].Name.get(0).compareTo(students[j + 1].Name.get(0)) < 0) {
                    Student temp = new Student();
                    temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            System.out.format("%s %.02f\n", students[i].Name.get(0), (double) students[i].Score);
        }
    }
}

class Student {
    List<String> Name = new ArrayList();
    double Score = 0;
    double CountSessions = 0;

    public List<String> getName() {
        return Name;
    }

    public void setName(List<String> name) {
        Name = name;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public double getCountSessions() {
        return CountSessions;
    }

    public void setCountSessions(double countSessions) {
        CountSessions = countSessions;
    }
}