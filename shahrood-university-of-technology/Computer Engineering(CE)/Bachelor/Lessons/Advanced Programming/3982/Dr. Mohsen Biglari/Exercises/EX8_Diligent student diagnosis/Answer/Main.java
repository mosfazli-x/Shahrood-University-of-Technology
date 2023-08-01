import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    Students students;
    int k = 0;
    int l = 0;

    public static void main(String[] args) throws IOException {
        Main baseManagerCommander = new Main();

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        while (scanner.hasNext()) {
            baseManagerCommander.process(printWriter, scanner.nextLine().split(" "));
        }
        printWriter.close();
    }

    public void process(PrintWriter printWriter, String... command) {
        if (command.length == 0) return;
        Scanner in = new Scanner(System.in);


        switch (command[0]) {
            case "new":

                students = new Students();

                break;
            case "name":
                students.setFirstName(command[1]);
                students.setLastName(command[2]);
                break;
            case "homework":
                String Id = "";
                String TimeStart = "";
                String TimeEnd = "";
                String Grade = "";
                for (int i = 0; i < command[1].length(); i++) {
                    if (command[1].charAt(i) != '[' && command[1].charAt(i) != ']') {
                        Id += command[1].charAt(i);
                    }
                }
                if (command[2].length() > 9) {
                    for (int j = 0; j <= 7; j++) {
                        TimeStart += command[2].charAt(j);
                    }
                    for (int j = 9; j <= 16; j++) {
                        TimeEnd += command[2].charAt(j);
                    }



                    for (int i = 0; i < command[3].length(); i++) {
                        if (command[3].charAt(i) != '(' && command[3].charAt(i) != ')') {
                            Grade += command[3].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] != null) {
                            if (students.HomeWorkTimeId[i][0].equals(Id)) {
                                students.HomeWorkTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] == null) {
                            students.HomeWorkTimeId[i][0] = Id;
                            students.HomeWorkTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.HomeWorkTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence(TimeStart, TimeEnd);


                }
                if (command[2].length() == 8) {
                    TimeStart = command[2];
                    TimeEnd = command[3];


                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] != null) {
                            if (students.HomeWorkTimeId[i][0].equals(Id)) {
                                students.HomeWorkTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] == null) {
                            students.HomeWorkTimeId[i][0] = Id;
                            students.HomeWorkTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.HomeWorkTimeId[i][2] = Grade;
                            break;
                        }
                    }

                    //CalculateTimeDiffrence(TimeStart, TimeEnd);

                }

                if (command[2].length() == 5) {
                    TimeStart = command[2] + ":00";
                    TimeEnd = command[3] + ":00";



                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] != null) {
                            if (students.HomeWorkTimeId[i][0].equals(Id)) {
                                students.HomeWorkTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] == null) {
                            students.HomeWorkTimeId[i][0] = Id;
                            students.HomeWorkTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.HomeWorkTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence2(TimeStart, TimeEnd);
                }

                if (command[2].length() == 2) {
                    TimeStart = command[2] + ":00:00";
                    TimeEnd = command[3] + ":00:00";


                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] != null) {
                            if (students.HomeWorkTimeId[i][0].equals(Id)) {
                                students.HomeWorkTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.HomeWorkTimeId[i][0] == null) {
                            students.HomeWorkTimeId[i][0] = Id;
                            students.HomeWorkTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.HomeWorkTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence3(TimeStart, TimeEnd);
                }


                break;
            case "project":


                Id = "";
                TimeStart = "";
                TimeEnd = "";
                Grade = "";
                for (int i = 0; i < command[1].length(); i++) {
                    if (command[1].charAt(i) != '[' && command[1].charAt(i) != ']') {
                        Id += command[1].charAt(i);
                    }
                }
                if (command[2].length() > 9) {
                    for (int j = 0; j <= 7; j++) {
                        TimeStart += command[2].charAt(j);
                    }
                    for (int j = 9; j <= 16; j++) {
                        TimeEnd += command[2].charAt(j);
                    }



                    for (int i = 0; i < command[3].length(); i++) {
                        if (command[3].charAt(i) != '(' && command[3].charAt(i) != ')') {
                            Grade += command[3].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] != null) {
                            if (students.ProjectTimeId[i][0].equals(Id)) {
                                students.ProjectTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] == null) {
                            students.ProjectTimeId[i][0] = Id;
                            students.ProjectTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.ProjectTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence(TimeStart, TimeEnd);


                }
                if (command[2].length() == 8) {
                    TimeStart = command[2];
                    TimeEnd = command[3];


                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] != null) {
                            if (students.ProjectTimeId[i][0].equals(Id)) {
                                students.ProjectTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] == null) {
                            students.ProjectTimeId[i][0] = Id;
                            students.ProjectTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.ProjectTimeId[i][2] = Grade;
                            break;
                        }
                    }

                    //CalculateTimeDiffrence(TimeStart, TimeEnd);

                }

                if (command[2].length() == 5) {
                    TimeStart = command[2];
                    TimeEnd = command[3];



                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] != null) {
                            if (students.ProjectTimeId[i][0].equals(Id)) {
                                students.ProjectTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] == null) {
                            students.ProjectTimeId[i][0] = Id;
                            students.ProjectTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.ProjectTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence2(TimeStart, TimeEnd);
                }

                if (command[2].length() == 2) {
                    TimeStart = command[2];
                    TimeEnd = command[3];


                    for (int i = 0; i < command[4].length(); i++) {
                        if (command[4].charAt(i) != '(' && command[4].charAt(i) != ')') {
                            Grade += command[4].charAt(i);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] != null) {
                            if (students.ProjectTimeId[i][0].equals(Id)) {
                                students.ProjectTimeId[i][0] = null;
                            }
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        if (students.ProjectTimeId[i][0] == null) {
                            students.ProjectTimeId[i][0] = Id;
                            students.ProjectTimeId[i][1] = CalculateTimeDiffrence(TimeStart, TimeEnd);
                            students.ProjectTimeId[i][2] = Grade;
                            break;
                        }
                    }


                    //CalculateTimeDiffrence3(TimeStart, TimeEnd);
                }

                break;
            case "midterm":
                Id = "";
                Grade = "";
                for (int i = 0; i < command[1].length(); i++) {
                    if (command[1].charAt(i) != '[' && command[1].charAt(i) != ']') {
                        Id += command[1].charAt(i);
                    }
                }

                for (int i = 0; i < command[2].length(); i++) {
                    if (command[2].charAt(i) != '(' && command[2].charAt(i) != ')') {
                        Grade += command[2].charAt(i);
                    }
                }


                for (int i = 0; i < 10; i++) {
                    if (students.MidTermIdGrade[i][0] != null) {
                        if (students.MidTermIdGrade[i][0].equals(Id)) {
                            students.MidTermIdGrade[i][0] = null;
                        }
                    }
                }

                for (int i = 1; i < 10; i++) {
                    if (students.MidTermIdGrade[i][0] == null) {
                        students.MidTermIdGrade[i][0] = Id;
                        students.MidTermIdGrade[i][1] = Grade;
                        break;
                    }
                }
                break;

            case "final":
                Id = "";
                Grade = "";
                for (int i = 0; i < command[1].length(); i++) {
                    if (command[1].charAt(i) != '[' && command[1].charAt(i) != ']') {
                        Id += command[1].charAt(i);
                    }
                }

                for (int i = 0; i < command[2].length(); i++) {
                    if (command[2].charAt(i) != '(' && command[2].charAt(i) != ')') {
                        Grade += command[2].charAt(i);
                    }
                }


                for (int i = 0; i < 10; i++) {
                    if (students.FinalIdGrade[i][0] != null) {
                        if (students.FinalIdGrade[i][0].equals(Id)) {
                            students.FinalIdGrade[i][0] = null;
                        }
                    }
                }

                for (int i = 1; i < 10; i++) {
                    if (students.FinalIdGrade[i][0] == null) {
                        students.FinalIdGrade[i][0] = Id;
                        students.FinalIdGrade[i][1] = Grade;
                        break;
                    }
                }
                break;

            case "report":

                String HomeWorkTime = "";
                String HomeWorkGrade = "";
                int HomeWorkGrade2 = 0;
                int h = 0;

                if (students.HomeWorkTimeId[0][0] != null) {
                    HomeWorkTime = students.HomeWorkTimeId[0][1];
                    HomeWorkGrade = students.HomeWorkTimeId[0][2];
                    HomeWorkGrade2 = Integer.parseInt(HomeWorkGrade);
                    h = 1;
                }

                for (int i = 1; i < 10; i++) {
                    if (students.HomeWorkTimeId[i][0] != null) {
                        HomeWorkTime = CalculateTimeSum(students.HomeWorkTimeId[i][1], HomeWorkTime);
                        HomeWorkGrade2 += Integer.parseInt(students.HomeWorkTimeId[i][2]);
                        h++;
                    }
                }

                if (HomeWorkTime == "") {
                    HomeWorkTime = "00:00:00";
                    HomeWorkGrade2 = 0;
                }


                String ProjectTime = "";
                String ProjectGrade = "";
                int ProjectGrade2 = 0;
                int p = 0;

                if (students.ProjectTimeId[0][0] != null) {
                    ProjectTime = students.ProjectTimeId[0][1];
                    ProjectGrade = students.ProjectTimeId[0][2];
                    ProjectGrade2 = Integer.parseInt(ProjectGrade);
                    p = 1;
                }

                for (int i = 1; i < 10; i++) {
                    if (students.ProjectTimeId[i][0] != null) {
                        ProjectTime = CalculateTimeSum(students.ProjectTimeId[i][1], ProjectTime);
                        ProjectGrade2 += Integer.parseInt(students.ProjectTimeId[i][2]);
                        p++;
                    }
                }

                if (ProjectTime == "") {
                    ProjectTime = "00:00:00";
                    ProjectGrade2 = 0;
                }

                int Midterm = 0;
                int M = 0;
                if (students.MidTermIdGrade[0][0] != null) {
                    Midterm += Integer.parseInt(students.MidTermIdGrade[0][1]);
                    M = 1;
                }
                for (int i = 0; i < 10; i++) {
                    if (students.MidTermIdGrade[i][0] != null) {
                        Midterm += Integer.parseInt(students.MidTermIdGrade[i][1]);
                        M++;

                    }
                }

                if (M == 0) {
                    Midterm = 0;
                }

                int Final = 0;
                int F = 0;
                if (students.FinalIdGrade[0][0] != null) {
                    Final += Integer.parseInt(students.FinalIdGrade[0][1]);
                    F = 1;
                }
                for (int i = 0; i < 10; i++) {
                    if (students.FinalIdGrade[i][0] != null) {
                        Final += Integer.parseInt(students.FinalIdGrade[i][1]);
                        F++;
                    }
                }
                if (F == 0) {
                    Final = 0;
                }

                double Average = 0;

                System.out.println(students.getFirstName() + " " + students.getLastName());
                if (h > 0) {
                    System.out.println("Homeworks " + HomeWorkTime + " " + HomeWorkGrade2 / h);
                } else {
                    System.out.println("Homeworks " + HomeWorkTime + " " + HomeWorkGrade2);
                }
                if (p > 0) {
                    System.out.println("Projects " + ProjectTime + " " + ProjectGrade2 / p);
                } else {
                    System.out.println("Projects " + ProjectTime + " " + ProjectGrade2);
                }
                if (M > 0) {
                    System.out.println("Midterms " + Midterm / M);
                } else {
                    System.out.println("Midterms " + Midterm);
                }
                if (F > 0) {
                    System.out.println("Finals " + Final / F);
                } else {
                    System.out.println("Finals " + Final);
                }

                if (h == 0) {
                    h = 1;
                }
                if (p == 0) {
                    p = 1;
                }
                if (M == 0) {
                    M = 1;
                }
                if (F == 0) {
                    F = 1;
                }


                Average = ((0.2) * HomeWorkGrade2 / h) + ((0.3) * ProjectGrade2 / p) + ((0.2) * (Midterm / M)) + ((0.3) * Final / F);
                if (Average < 25) {
                    System.out.println("Bystander");
                }
                if (Average > 25 && Average < 50) {
                    System.out.println("Inactive");
                }
                if(Average>50 && Average < 75){
                    System.out.println("Naive");
                }
                if(Average>= 75){
                    System.out.println("Hardworker");
                }
                System.out.println();
                break;

            default:

        }

    }


    private static String CalculateTimeSum(String a, String b) {
        String ahour = "";
        ahour += (char) a.charAt(0);
        ahour += (char) a.charAt(1);
        String amin = "";
        amin += (char) a.charAt(3);
        amin += (char) a.charAt(4);
        String asec = "";
        asec += (char) a.charAt(6);
        asec += (char) a.charAt(7);
        String bhour = "";
        bhour += (char) b.charAt(0);
        bhour += (char) b.charAt(1);
        String bmin = "";
        bmin += (char) b.charAt(3);
        bmin += (char) b.charAt(4);
        String bsec = "";
        bsec += (char) b.charAt(6);
        bsec += (char) b.charAt(7);
        int Ahour = Integer.parseInt(ahour);
        int Amin = Integer.parseInt(amin);
        int Asec = Integer.parseInt(asec);
        int Bhour = Integer.parseInt(bhour);
        int Bmin = Integer.parseInt(bmin);
        int Bsec = Integer.parseInt(bsec);
        int Atime = (Ahour * 60 * 60) + (Amin * 60) + (Asec);
        int Btime = (Bhour * 60 * 60) + (Bmin * 60) + (Bsec);
        int Alltime = Atime + Btime;

        int Allhour = Alltime / 3600;
        Alltime = Alltime - (Allhour * 3600);
        int Allmin = Alltime / 60;
        Alltime = Alltime - (Allmin * 60);
        int Allsec = Alltime;

        String Time = "";

        if (Allhour < 10 && Allhour > 0) {
            Time += "0" + Allhour + ":";
        }
        if (Allhour >= 10) {
            Time += Allhour + ":";
        }
        if (Allhour == 0) {
            Time += "00:";
        }
        if (Allmin < 10 && Allmin > 0) {
            Time += "0" + Allmin + ":";
        }
        if (Allmin >= 10) {
            Time += Allmin + ":";
        }
        if (Allmin == 0) {
            Time += "00:";
        }
        if (Allsec < 10 && Allsec > 0) {
            Time += "0" + Allsec;
        }
        if (Allsec >= 10) {
            Time += Allsec;
        }
        if (Allsec == 0) {
            Time += "00";
        }

        return Time;

    }


    private static String CalculateTimeDiffrence(String dateStart, String dateStop) {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String DiffTime = "";
        Date d1;
        Date d2;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

// in milliseconds
            long diff = d2.getTime() - d1.getTime();
            long x = 86400000;

            if(diff < 0){
                x += diff+1000;
            }else{
                x = diff+1000;
            }


            long diffSeconds = x / 1000 % 60 ;
            long diffMinutes = x / (60 * 1000) % 60;
            long diffHours = x / (60 * 60 * 1000) % 24;

            if (diffHours < 10 && diffHours > 0) {
                DiffTime += "0" + String.valueOf(diffHours) + ":";
            }
            if (diffHours >= 10) {
                DiffTime += String.valueOf(diffHours) + ":";
            }
            if (diffHours == 0) {
                DiffTime += "00:";
            }

            if (diffMinutes < 10 && diffMinutes > 0) {
                DiffTime += "0" + String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes >= 10) {
                DiffTime += String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes == 0) {
                DiffTime += "00:";
            }

            if (diffSeconds < 10 && diffSeconds > 0) {
                DiffTime += "0" + String.valueOf(diffSeconds);
            }
            if (diffSeconds >= 10) {
                DiffTime += String.valueOf(diffSeconds);
            }
            if (diffSeconds == 0) {
                DiffTime += "00";
            }

            /*System.out.printf("%02d:", diffHours);
            System.out.printf("%02d:", diffMinutes);
            System.out.printf("%02d", diffSeconds);
*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DiffTime;


    }


    private static String CalculateTimeDiffrence2(String dateStart, String dateStop) {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1;
        Date d2;
        String DiffTime = "";
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

// in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = 0;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;

            if (diffHours < 10 && diffHours > 0) {
                DiffTime += "0" + String.valueOf(diffHours) + ":";
            }
            if (diffHours >= 10) {
                DiffTime += String.valueOf(diffHours) + ":";
            }
            if (diffHours == 0) {
                DiffTime += "00:";
            }

            if (diffMinutes < 10 && diffMinutes > 0) {
                DiffTime += "0" + String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes >= 10) {
                DiffTime += String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes == 0) {
                DiffTime += "00:";
            }

            if (diffSeconds < 10 && diffSeconds > 0) {
                DiffTime += "0" + String.valueOf(diffSeconds);
            }
            if (diffSeconds >= 10) {
                DiffTime += String.valueOf(diffSeconds);
            }
            if (diffSeconds == 0) {
                DiffTime += "00";
            }
         /*   System.out.printf("%02d:", diffHours);
            System.out.printf("%02d", diffMinutes);
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DiffTime;

    }

    private static String CalculateTimeDiffrence3(String dateStart, String dateStop) {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1;
        Date d2;
        String DiffTime = "";

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);


            long diff = d2.getTime() - d1.getTime();

            long diffMinutes = 0;
            long diffSeconds = 0;
            long diffHours = diff / (60 * 60 * 1000) % 24;

            if (diffHours < 10 && diffHours > 0) {
                DiffTime += "0" + String.valueOf(diffHours) + ":";
            }
            if (diffHours >= 10) {
                DiffTime += String.valueOf(diffHours) + ":";
            }
            if (diffHours == 0) {
                DiffTime += "00";
            }

            if (diffMinutes < 10 && diffMinutes > 0) {
                DiffTime += "0" + String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes >= 10) {
                DiffTime += String.valueOf(diffMinutes) + ":";
            }
            if (diffMinutes == 0) {
                DiffTime += "00:";
            }

            if (diffSeconds < 10 && diffSeconds > 0) {
                DiffTime += "0" + String.valueOf(diffSeconds);
            }
            if (diffSeconds >= 10) {
                DiffTime += String.valueOf(diffSeconds);
            }
            if (diffSeconds == 0) {
                DiffTime += "00";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DiffTime;

    }


    public String TimeDiffCal(String a,String b){
        String ahour = "";
        ahour += (char) a.charAt(0);
        ahour += (char) a.charAt(1);
        String amin = "";
        amin += (char) a.charAt(3);
        amin += (char) a.charAt(4);
        String asec = "";
        asec += (char) a.charAt(6);
        asec += (char) a.charAt(7);
        String bhour = "";
        bhour += (char) b.charAt(0);
        bhour += (char) b.charAt(1);
        String bmin = "";
        bmin += (char) b.charAt(3);
        bmin += (char) b.charAt(4);
        String bsec = "";
        bsec += (char) b.charAt(6);
        bsec += (char) b.charAt(7);
        int Ahour = Integer.parseInt(ahour);
        int Amin = Integer.parseInt(amin);
        int Asec = Integer.parseInt(asec);
        int Bhour = Integer.parseInt(bhour);
        int Bmin = Integer.parseInt(bmin);
        int Bsec = Integer.parseInt(bsec);
        int Atime = (Ahour * 60 * 60) + (Amin * 60) + (Asec);
        int Btime = (Bhour * 60 * 60) + (Bmin * 60) + (Bsec);
        int Alltime = Btime - Atime;

        int Allhour = Alltime / 3600;
        Alltime = Alltime - (Allhour * 3600);
        int Allmin = Alltime / 60;
        Alltime = Alltime - (Allmin * 60);
        int Allsec = Alltime;

        String Time = "";

        if (Allhour < 10 && Allhour > 0) {
            Time += "0" + Allhour + ":";
        }
        if (Allhour >= 10) {
            Time += Allhour + ":";
        }
        if (Allhour == 0) {
            Time += "00:";
        }
        if (Allmin < 10 && Allmin > 0) {
            Time += "0" + Allmin + ":";
        }
        if (Allmin >= 10) {
            Time += Allmin + ":";
        }
        if (Allmin == 0) {
            Time += "00:";
        }
        if (Allsec < 10 && Allsec > 0) {
            Time += "0" + Allsec;
        }
        if (Allmin >= 10) {
            Time += Allsec;
        }
        if (Allsec == 0) {
            Time += "00";
        }

        return Time;
    }


}


class Students {

    private String FirstName = "";
    private String LastName = "";

    int HomeWorkId;
    String[][] HomeWorkTimeId = new String[10][3];
    String HomeWorkStartHour;
    String HomeWorkStartMin;
    String HomeWorkStartSec;
    String HomeWorkEndHour;
    String HomeWorkEndMin;
    String HomeWorkEndSec;
    String HomeWorkGrade;

    int ProjectId;
    String[][] ProjectTimeId = new String[10][3];
    String ProjectStartHour;
    String ProjectStartMin;
    String ProjectStartSec;
    String ProjectEndHour;
    String ProjectEndMin;
    String ProjectEndSec;
    String ProjectGrade;

    String[][] MidTermIdGrade = new String[10][2];

    String[][] FinalIdGrade = new String[10][2];

    public String[][] getMidTermIdGrade() {
        return MidTermIdGrade;
    }

    public void setMidTermIdGrade(String[][] midTermIdGrade) {
        MidTermIdGrade = midTermIdGrade;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getHomeWorkId() {
        return HomeWorkId;
    }

    public void setHomeWorkId(int homeWorkId) {
        HomeWorkId = homeWorkId;
    }

    public String[][] getHomeWorkTimeId() {
        return HomeWorkTimeId;
    }

    public void setHomeWorkTimeId(String[][] homeWorkTimeId) {
        HomeWorkTimeId = homeWorkTimeId;
    }

    public String getHomeWorkStartHour() {
        return HomeWorkStartHour;
    }

    public void setHomeWorkStartHour(String homeWorkStartHour) {
        HomeWorkStartHour = homeWorkStartHour;
    }

    public String getHomeWorkStartMin() {
        return HomeWorkStartMin;
    }

    public void setHomeWorkStartMin(String homeWorkStartMin) {
        HomeWorkStartMin = homeWorkStartMin;
    }

    public String getHomeWorkStartSec() {
        return HomeWorkStartSec;
    }

    public void setHomeWorkStartSec(String homeWorkStartSec) {
        HomeWorkStartSec = homeWorkStartSec;
    }

    public String getHomeWorkEndHour() {
        return HomeWorkEndHour;
    }

    public void setHomeWorkEndHour(String homeWorkEndHour) {
        HomeWorkEndHour = homeWorkEndHour;
    }

    public String getHomeWorkEndMin() {
        return HomeWorkEndMin;
    }

    public void setHomeWorkEndMin(String homeWorkEndMin) {
        HomeWorkEndMin = homeWorkEndMin;
    }

    public String getHomeWorkEndSec() {
        return HomeWorkEndSec;
    }

    public void setHomeWorkEndSec(String homeWorkEndSec) {
        HomeWorkEndSec = homeWorkEndSec;
    }

    public String getHomeWorkGrade() {
        return HomeWorkGrade;
    }

    public void setHomeWorkGrade(String homeWorkGrade) {
        HomeWorkGrade = homeWorkGrade;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String[][] getProjectTimeId() {
        return ProjectTimeId;
    }

    public void setProjectTimeId(String[][] projectTimeId) {
        ProjectTimeId = projectTimeId;
    }

    public String getProjectStartHour() {
        return ProjectStartHour;
    }

    public void setProjectStartHour(String projectStartHour) {
        ProjectStartHour = projectStartHour;
    }

    public String getProjectStartMin() {
        return ProjectStartMin;
    }

    public void setProjectStartMin(String projectStartMin) {
        ProjectStartMin = projectStartMin;
    }

    public String getProjectStartSec() {
        return ProjectStartSec;
    }

    public void setProjectStartSec(String projectStartSec) {
        ProjectStartSec = projectStartSec;
    }

    public String getProjectEndHour() {
        return ProjectEndHour;
    }

    public void setProjectEndHour(String projectEndHour) {
        ProjectEndHour = projectEndHour;
    }

    public String getProjectEndMin() {
        return ProjectEndMin;
    }

    public void setProjectEndMin(String projectEndMin) {
        ProjectEndMin = projectEndMin;
    }

    public String getProjectEndSec() {
        return ProjectEndSec;
    }

    public void setProjectEndSec(String projectEndSec) {
        ProjectEndSec = projectEndSec;
    }

    public String getProjectGrade() {
        return ProjectGrade;
    }

    public void setProjectGrade(String projectGrade) {
        ProjectGrade = projectGrade;
    }
}