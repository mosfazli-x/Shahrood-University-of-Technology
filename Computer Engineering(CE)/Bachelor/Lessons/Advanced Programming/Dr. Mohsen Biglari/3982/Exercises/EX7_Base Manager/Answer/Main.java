import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Main {

    BaseManager baseManager;


    public Main() throws IOException {
        baseManager = new MyBaseManager("1", 10);
    }

    public static void main(String[] args) throws IOException {
        Main baseManagerCommander = new Main();

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        while (scanner.hasNext()) {
            baseManagerCommander.process(printWriter, scanner.nextLine().split(" "));
        }
        printWriter.close();
    }
    int x = 0;
    public void process(PrintWriter printWriter, String... command) {
        if (command.length == 0) return;

        String num;
        int base;

        switch (command[0]) {
            case "set":
                num = command[1];
                base = Integer.valueOf(command[2]);
                x = base;
                baseManager.setNumberInBase(num, base);
                baseManager.getInAllBases();
                break;
            case "print":
                baseManager.print();
                break;
            case "printAll":
                baseManager.printAll();
                break;
            case "equal":
                num = command[1];
                base = Integer.valueOf(command[2]);
                // BaseManager newBaseManager = new MyBaseManager(num, base);
                if (baseManager.convertToBase(num, base) == 1) {
                    System.out.println("TRUE");
                } else {
                    System.out.println("FALSE");
                }
                //printWriter.println(baseManager.equals(newBaseManager) ? "TRUE" : "FALSE");
                break;
            case "sum":
                num = command[1];
                base = Integer.valueOf(command[2]);
                baseManager.sumInBase(num, base);
                num = Integer.toString(baseManager.q);
                baseManager.printSum(num,x);
                //printWriter.println(baseManager.sumInBase(num, base));
                break;
            default:
                printWriter.println("Invalid Command!");
        }
    }

}


abstract class BaseManager {
    int q;
    String[][] arr = new String[17][2];
    String[][] arr2 = new String[17][2];
    protected String number;
    protected int base;

    public BaseManager() {
        setNumberInBase(number, base);
    }

    public final void setNumberInBase(String number, int base) {
        this.number = number;
        this.base = base;
    }

    // convert number from base to newBase and return
    public abstract int convertToBase(String string, int newBase);

    // sum [this.number with this.base] and [number with base] and return the result in this.base
    public abstract void sumInBase(String number, int base);

    // return this.number in base 2..16
    public abstract void getInAllBases();

    public void print() {
        System.out.printf("%s (%02d)\n", number, base);
    }

    public void printAll() {

        for (int j = 2; j <= 16; j++) {
            if (j < 16) {
                System.out.printf("%s (%02d) -- ", arr[j][0], Integer.parseInt(arr[j][1]));

            } else {
                System.out.printf("%s (%02d)\n", arr[j][0], Integer.parseInt(arr[j][1]));
            }

        }
    }

    void printSum(String numbe , int base2){
        String mabna1;
        int mabna2;
        int count = 0;
        int mod;
        char[] all = new char[100];
        String num2 = new String();
        for (int l = 0; l <= numbe.length() - 1; l++) {
            all[l] = numbe.charAt(l);
        }

        for (int i = 0; i <= 16; i++) {
            arr2[i][0] = "";
            arr2[i][1] = "";
        }

        mabna1 = String.valueOf(10);


        mabna2 = base2;

        int i = 0, count1 = 0, counter1 = 0;
        int ten = 0;
        int mynum = 0;
        for (i = 0; all[i] != '\0'; i++) counter1++;
        counter1--;
        for (i = counter1; i >= 0; i--) {
            if (all[i] >= 48 && all[i] <= 57) mynum = all[i] - 48;
            else if (all[i] == 'A' || all[i] == 'a') mynum = 10;
            else if (all[i] == 'B' || all[i] == 'b') mynum = 11;
            else if (all[i] == 'C' || all[i] == 'c') mynum = 12;
            else if (all[i] == 'D' || all[i] == 'd') mynum = 13;
            else if (all[i] == 'E' || all[i] == 'e') mynum = 14;
            else if (all[i] == 'F' || all[i] == 'f') mynum = 15;
            ten = (int) (ten + (mynum * pow(Double.parseDouble(mabna1), count1)));
            count1++;
        }

        mod = ten % mabna2;

        String h = "";
        if (mod <= 9 && mod >= 0) h += (char) (mod + 48);
        else if (mod == 10) h += 'A';
        else if (mod == 11) h += 'B';
        else if (mod == 12) h += 'C';
        else if (mod == 13) h += 'D';
        else if (mod == 14) h += 'E';
        else if (mod == 15) h += 'F';

        num2 += h;
        while (ten >= mabna2) {
            ten /= mabna2;
            mod = ten % mabna2;
            count++;

            char a = 0;
            if (mod <= 9 && mod >= 0) a = (char) (mod + 48);
            else if (mod == 10) a = 'A';
            else if (mod == 11) a = 'B';
            else if (mod == 12) a = 'C';
            else if (mod == 13) a = 'D';
            else if (mod == 14) a = 'E';
            else if (mod == 15) a = 'F';

            num2 += a;

        }

        for (int t = num2.length() - 1; t >= 0; t--) {

            System.out.print(num2.charAt(t));;

        }
        System.out.println();
        arr2[base2][1] += 10;

        num2 = "";


        count = 0;

    }
}


class MyBaseManager extends BaseManager {


    public MyBaseManager(String num, int base) {
        number = num;
        base = base;

    }

    @Override
    public int convertToBase(String num, int newBase) {

        if (arr[newBase][0].contains(num)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void sumInBase(String number, int base) {
        String mabna1;
        int mabna2;
        int count = 0;
        int mod;
        char[] all = new char[100];
        String num2 = new String();
        for (int l = 0; l <= number.length() - 1; l++) {
            all[l] = number.charAt(l);
        }

        for (int i = 0; i <= 16; i++) {
            arr2[i][0] = "";
            arr2[i][1] = "";
        }

        mabna1 = String.valueOf(base);


        mabna2 = 10;

        int i = 0, count1 = 0, counter1 = 0;
        int ten = 0;
        int mynum = 0;
        for (i = 0; all[i] != '\0'; i++) counter1++;
        counter1--;
        for (i = counter1; i >= 0; i--) {
            if (all[i] >= 48 && all[i] <= 57) mynum = all[i] - 48;
            else if (all[i] == 'A' || all[i] == 'a') mynum = 10;
            else if (all[i] == 'B' || all[i] == 'b') mynum = 11;
            else if (all[i] == 'C' || all[i] == 'c') mynum = 12;
            else if (all[i] == 'D' || all[i] == 'd') mynum = 13;
            else if (all[i] == 'E' || all[i] == 'e') mynum = 14;
            else if (all[i] == 'F' || all[i] == 'f') mynum = 15;
            ten = (int) (ten + (mynum * pow(Double.parseDouble(mabna1), count1)));
            count1++;
        }

        mod = ten % mabna2;

        String h = "";
        if (mod <= 9 && mod >= 0) h += (char) (mod + 48);
        else if (mod == 10) h += 'A';
        else if (mod == 11) h += 'B';
        else if (mod == 12) h += 'C';
        else if (mod == 13) h += 'D';
        else if (mod == 14) h += 'E';
        else if (mod == 15) h += 'F';

        num2 += h;
        while (ten >= mabna2) {
            ten /= mabna2;
            mod = ten % mabna2;
            count++;

            char a = 0;
            if (mod <= 9 && mod >= 0) a = (char) (mod + 48);
            else if (mod == 10) a = 'A';
            else if (mod == 11) a = 'B';
            else if (mod == 12) a = 'C';
            else if (mod == 13) a = 'D';
            else if (mod == 14) a = 'E';
            else if (mod == 15) a = 'F';

            num2 += a;

        }

        for (int t = num2.length() - 1; t >= 0; t--) {

            arr2[10][0] += num2.charAt(t);

        }
        arr2[10][1] += 10;

        num2 = "";


        count = 0;


        q = Integer.valueOf(arr[10][0]);
        int w = Integer.valueOf(arr2[10][0]);
        q += w;



    }

    @Override
    public void getInAllBases() {
        String mabna1;
        int mabna2;
        int count = 0;
        int mod;
        char[] all = new char[100];
        String num2 = new String();
        for (int l = 0; l <= number.length()-1; l++) {
            all[l] = number.charAt(l);
        }

        for (int i = 0; i <= 16; i++) {
            arr[i][0] = "";
            arr[i][1] = "";
        }

        mabna1 = String.valueOf(base);

        for (int j = 2; j <= 16; j++) {

            mabna2 = j;

            int i = 0, count1 = 0, counter1 = 0;
            int ten = 0;
            int mynum = 0;
            for (i = 0; all[i] != '\0'; i++) counter1++;
            counter1--;
            for (i = counter1; i >= 0; i--) {
                if (all[i] >= 48 && all[i] <= 57) mynum = all[i] - 48;
                else if (all[i] == 'A' || all[i] == 'a') mynum = 10;
                else if (all[i] == 'B' || all[i] == 'b') mynum = 11;
                else if (all[i] == 'C' || all[i] == 'c') mynum = 12;
                else if (all[i] == 'D' || all[i] == 'd') mynum = 13;
                else if (all[i] == 'E' || all[i] == 'e') mynum = 14;
                else if (all[i] == 'F' || all[i] == 'f') mynum = 15;
                ten = (int) (ten + (mynum * pow(Double.parseDouble(mabna1), count1)));
                count1++;
            }

            mod = ten % mabna2;

            String h = "";
            if (mod <= 9 && mod >= 0) h += (char) (mod + 48);
            else if (mod == 10) h += 'A';
            else if (mod == 11) h += 'B';
            else if (mod == 12) h += 'C';
            else if (mod == 13) h += 'D';
            else if (mod == 14) h += 'E';
            else if (mod == 15) h += 'F';

            num2 += h;
            while (ten >= mabna2) {
                ten /= mabna2;
                mod = ten % mabna2;
                count++;

                char a = 0;
                if (mod <= 9 && mod >= 0) a = (char) (mod + 48);
                else if (mod == 10) a = 'A';
                else if (mod == 11) a = 'B';
                else if (mod == 12) a = 'C';
                else if (mod == 13) a = 'D';
                else if (mod == 14) a = 'E';
                else if (mod == 15) a = 'F';

                num2 += a;

            }

            if (j < 16) {
                for (int t = num2.length() - 1; t >= 0; t--) {

                    arr[j][0] += num2.charAt(t);

                }
                arr[j][1] += j;

                num2 = "";


                count = 0;
            } else {
                for (int t = num2.length() - 1; t >= 0; t--) {

                    arr[j][0] += num2.charAt(t);

                }
                arr[j][1] += j;

                num2 = "";


                count = 0;
            }

        }

    }
}