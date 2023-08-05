import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner  scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        int temp ;
        String temp2;
        int op = 0;

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                temp = scanner.nextInt();
                if(i == 0){
                    sum = temp;
                    i++;
                }else{
                    if(op == 1){
                        sum *= temp;
                    }
                    if(op == 2){
                        sum /= temp;
                    }
                    if(op == 3){
                        sum %= temp;
                    }

                }
            }
            else{
                temp2 = scanner.next();
                if(temp2.equals("*")){
                    op = 1;
                }
                if(temp2.equals("/")){
                    op = 2;
                }
                if(temp2.equals("%")){
                    op = 3;
                }
            }
        }
        System.out.println(sum);

    }
}