import java.io.IOException;

public class Main {
    public static String readWord(StringBuilder args) throws IOException {
        {

            System.out.println("WORD: " + args);

        }
        return "";
    }

    public static float readFloat(float args) throws IOException {

        for (int i = 1; i < 2; i++) {

            System.out.printf("FLOAT: %.3f\n",args);
            break;
            //}
        }
        return 0;
    }

    public static int readInt(StringBuilder args) throws IOException {
        int e = 1;
        int g=0;
        for (int i = 0; i < args.length(); i++) {
            if (args.charAt(i) <= 57 && args.charAt(i) >= 48 && args.charAt(i) != 46) {
                e++;
            }
            if (args.charAt(i) == 46) {
                g++;
            }
            if ((args.charAt(i) > 57 || args.charAt(i) < 48) && args.charAt(i) != 46) {
                readWord(args);
                return 0;
            }
        }
        if(g == 1){
            float w = Float.parseFloat(String.valueOf(args));
            readFloat(w);
            return 0;
        }
        if(g > 1 ){
            readWord(args);
            return 0;
        }
        if (e > 1) {
            System.out.println("INT: " + args);
        }

        return e;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder string = new StringBuilder();
        int c = 0;
        int count = 0;
        while ((c = System.in.read()) != -1) {
            string.append((char) c);
            if (c == 9 || c == 10 || c == 32) {
                string.delete(string.length() - 1, string.length());
                if (string.length() != 0) {

                    readInt(string);
                    string.delete(0, string.length());

                }

            }

        }
        readInt(string);
        //   System.out.println("\n");

        //string.delete(1, string.length()-2);


    }

}
