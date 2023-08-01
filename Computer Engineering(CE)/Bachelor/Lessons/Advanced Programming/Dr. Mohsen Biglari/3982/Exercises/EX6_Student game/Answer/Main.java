import java.util.Scanner;

class Student {

    public static Team ar[] = new Team[2000];
    private static int i = 1;

    void addteam(Team team) {
        ar[i] = team;
        i++;
    }

    void Tas(int k, int n, int x) {
        for (int i = 1; i <= n; i++) {
            if (k % n == ar[i].nobat) {
                if (x == 6) {
                    ar[i].chance6--;
                    ar[i].temp = ar[i].temp -1;
                }
                if(ar[i].chance != 0 && ar[i].chance6 == 0 && ar[i].temp < 0){
                    ar[i].chance--;
                    ar[i].temp = ar[i].temp -1;
                }
                if (ar[i].chance6 == 0 && ar[i].chance == 0 && ar[i].temp < 0) {
                    ar[i].Score++;
                }
                if(ar[i].chance6 == 0){
                    ar[i].temp = ar[i].temp - 1;
                }
            }
        }
        if (k % n == 0 && k > n) {
            if (x == 6) {
                ar[n].chance6--;
                ar[n].temp = ar[n].temp -1;
            }
            if(ar[n].chance != 0 && ar[n].chance6 == 0 && ar[n].temp < 0){
                ar[n].chance--;
                ar[n].temp = ar[n].temp -1;
            }
            if (ar[n].chance6 == 0 && ar[n].chance == 0 && ar[n].temp < 0) {
                ar[n].Score++;
            }
            if(ar[n].chance6 == 0){
                ar[n].temp = ar[n].temp - 1;
            }
        }

    }

    void Print(int n){
        int max = ar[1].Score;
        for(int r = 2 ; r <= n ; r++) {
            if (max < ar[r].Score) {
                max = ar[r].Score;
            }
        }
            System.out.println("Max Score: " + max); //Max Score: 0
        Team temp = new Team();
        for(int i = 1 ; i <= n ;i++) {
            for (int y = 1; y < n; y++) {
                if (ar[y].Score == max) {
                    if (ar[y].Name.compareTo(ar[y + 1].Name) > 0) {
                        temp = ar[y + 1];
                        ar[y + 1] = ar[y];
                        ar[y] = temp;
                    }
                }
            }
        }
            for(int i = 1 ; i <= n ; i++){
                if(ar[i].Score == max)
                System.out.println(ar[i].Name);
            }
    }

    class Team {
        String Name = " ";
        int Unit = 0;
        int Score = 0;
        int nobat = 0;
        int chance = 3;
        int chance6 = 1;
        int temp = 1;


        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public int getUnit() {
            return Unit;
        }

        public void setUnit(int unit) {
            if (unit == 8) {
                chance = 0;
            }
            if (unit == 2) {
                chance = 1;
            }
            if (unit == 1) {
                chance = 2;
            }
            this.Unit = unit;
        }

        public int getNobat() {
            return nobat;
        }

        public void setNobat(int nobat) {
            this.nobat = nobat;
        }

        public int getChance6() {
            return chance6;
        }

        public void setChance6(int chance6) {
            this.chance6 = chance6;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }
    }


}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = 1;
        int n = in.nextInt();
        Student o1 = new Student();
        for (int i = 0; i < n; i++) {
            Student.Team c1 = o1.new Team();
            c1.setName(in.next());
            c1.setUnit(in.nextInt());
            c1.setNobat(q);
            o1.addteam(c1);
            q++;
        }

        int Tas;
        int k = 1;
        while (in.hasNextInt()) {
            Tas = in.nextInt();
            o1.Tas(k, n, Tas);
            k++;
        }
        o1.Print(n);
    }
}