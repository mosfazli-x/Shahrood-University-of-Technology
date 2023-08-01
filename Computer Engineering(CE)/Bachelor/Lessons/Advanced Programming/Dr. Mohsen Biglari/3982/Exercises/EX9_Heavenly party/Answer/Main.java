import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int k = 0;
    public static int l = 0;
    public static int n;
    public static int i = 0;
    public static String[] p = new String[9999];
    public static String[] f = new String[9999];
    public static int arr[] = new int[9999];
    public static String[][] words = new String[9999][];


    public static void main(String[] args) {
        Main baseManagerCommander = new Main();
        for (int j = 0; j < 9999; j++) {
            f[j] = "";
            p[j] = "";
        }

        n = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        while (i <= n) {
            baseManagerCommander.process(printWriter, scanner.nextLine().split(" "));
            i++;
        }
       // printWriter.close();

        for(int m = 0 ; m < k ; m++){
           words[m] = f[m].split(" ");
           arr[m] = words[m].length;
        }


        int temp ;
        String temp2;
        String[] temp3 = new String[9999];
        for(int b = 0 ; b < k+2 ; b++) {
            for (int v = 0; v < k - 1; v++) {
                if (arr[v] > arr[v + 1]) {
                    temp = arr[v];
                    arr[v] = arr[v + 1];
                    arr[v + 1] = temp;
                    temp2 = p[v];
                    p[v] = p[v + 1];
                    p[v + 1] = temp2;
                    temp3 = words[v];
                    words[v] = words[v + 1];
                    words[v + 1] = temp3;
                }if(arr[v] == arr[v+1] && p[v].compareTo(p[v+1]) < 0){
                    temp = arr[v];
                    arr[v] = arr[v + 1];
                    arr[v + 1] = temp;
                    temp2 = p[v];
                    p[v] = p[v + 1];
                    p[v + 1] = temp2;
                    temp3 = words[v];
                    words[v] = words[v + 1];
                    words[v + 1] = temp3;
                }
            }
        }

        print();

        //System.out.println(words);
    }

    public void process(PrintWriter printWriter, String... command) {
        if (command.length == 0) return;
        Scanner in = new Scanner(System.in);

        for (int j = i - 1; j <= n; j++) {
            if (i != 0) {
                if (i == 1) {
                    p[j] = command[0].toLowerCase();
                    f[j] += command[1].toLowerCase();
                    k++;
                    break;

                } else {
                    int l = 0;
                    for (int q = 0; q < n; q++) {
                        if (p[q].equals(command[0].toLowerCase())) {
                            if (p[q].equals(command[0].toLowerCase())) {
                                f[q] += " " + command[1].toLowerCase();
                                l++;
                                break;
                            }
                        }
                    }
                    if (l == 0) {
                        p[k] = command[0].toLowerCase();
                        f[k] += command[1].toLowerCase();
                        k++;
                        break;
                    }
                }
            }
            break;
        }

        //Map<String,Integer> map = new Map<String, Integer>();

    }

    static void print(){


        for(int r = k-1 ; r >= 0 ; r--) {
            System.out.print(p[r] + " " + arr[r] + " ");
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String name : words[r]) {
                if (map.containsKey(name)) {
                    int val = map.get(name);
                    map.put(name, val + 1);
                } else {
                    map.put(name, 1);
                }
            }
            String[] words2 = new String[9999];
            String[] words3 = new String[9999];
            String[] temp = new String[9999];
            String[] temp2 = new String[9999];
            String temp3;
            temp[0] = String.valueOf(map.keySet());
            temp[0]=temp[0].replaceAll("\\s","");
            words2 = temp[0].split("[,\\[\\]]");
            temp2[0] = String.valueOf(map.values());
            temp2[0]=temp2[0].replaceAll("\\s","");
            words3 = temp2[0].split("[,\\[\\]]");
       //     System.out.println(map.keySet() + " " + map.values());
            for(int a = 0 ; a < words2.length+2 ; a++){
                for(int z = 1 ; z < words3.length-1 ; z++){
                    if(words3[z].compareTo(words3[z+1]) > 0){
                        temp3 = words3[z];
                        words3[z] = words3[z+1];
                        words3[z+1] = temp3;
                        temp3 = words2[z];
                        words2[z] = words2[z+1];
                        words2[z+1] = temp3;
                    }else if(words3[z].compareTo(words3[z+1]) == 0 && words2[z].compareTo(words2[z+1]) < 0){
                        temp3 = words3[z];
                        words3[z] = words3[z+1];
                        words3[z+1] = temp3;
                        temp3 = words2[z];
                        words2[z] = words2[z+1];
                        words2[z+1] = temp3;
                    }
                }
            }
            for(int e = words2.length -1 ; e > 0 ; e--){
                System.out.printf("[" + words2[e] + " " + words3[e] + "] ");
            }
                System.out.println();

        }

    }


}