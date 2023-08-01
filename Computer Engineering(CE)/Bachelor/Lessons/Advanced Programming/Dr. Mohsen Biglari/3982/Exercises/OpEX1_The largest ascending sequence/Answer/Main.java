import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int[] arr = new int[n];
        int[] x = new int[n];
        int t = 1;
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(arr[i] < arr[j]){
                  t++;
                  i = j;
                }
            }
            x[i] = t;
            t=0;
        }
        int max;
        Arrays.sort(x);
        max = x[n-1];

        System.out.print(max);
    }
}