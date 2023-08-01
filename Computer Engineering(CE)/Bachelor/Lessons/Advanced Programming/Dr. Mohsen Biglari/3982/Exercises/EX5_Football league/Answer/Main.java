import java.util.Scanner;

class LeagueManager {

    public static Team ar[] = new Team[2000];
    private static int i = 1;

    void addteam(Team team) {
        ar[i] = team;
        i++;
    }

    class Team {
        String Name = " ";
        int win = 0;
        int draw = 0;
        int lost = 0;
        int GF = 0;
        int GA = 0;
        int GD ;
        int Score = 0;
        int num = 0;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }
    }

    class TableDreawer {
        void TableDreawer(){
            int r = 1;
            Team[] order = new Team[i];
            int score[] = new int[i];
            Team min = new Team();
            Team max = new Team();
            min = ar[1];
            max = ar[1];
            Team temp = new Team();
            order[r] = ar[1];
            for(int u = 1 ; u < i    ; u++) {
                for (int k = 1; k < i - 1; k++) {
                    if (ar[k].Score > ar[k + 1].Score) {
                        temp = ar[k + 1];
                        ar[k + 1] = ar[k];
                        ar[k] = temp;
                    }
                    if (ar[k].Score == ar[k + 1].Score) {
                        if (ar[k].win > ar[k + 1].win) {
                            temp = ar[k + 1];
                            ar[k + 1] = ar[k];
                            ar[k] = temp;
                        }
                        if (ar[k].win == ar[k + 1].win) {
                            if (ar[k].GD > ar[k + 1].GD) {
                                temp = ar[k + 1];
                                ar[k + 1] = ar[k];
                                ar[k] = temp;
                            }
                            if (ar[k].GD == ar[k + 1].GD) {
                                if (ar[k].draw > ar[k + 1].draw) {
                                    temp = ar[k + 1];
                                    ar[k + 1] = ar[k];
                                    ar[k] = temp;
                                }
                                if (ar[k].draw == ar[k + 1].draw) {
                                    if (ar[k].Name.compareTo(ar[k+1].Name) < 0) {
                                        temp = ar[k + 1];
                                        ar[k + 1] = ar[k];
                                        ar[k] = temp;
                                    }

                                }
                            }
                        }
                    }
                }
            }
            /*for(int k = 1 ; k < i ; k++) {
                if(ar[k].Score < min.Score){
                    min = ar[k];
                }
                if(ar[k].Score == min.Score){
                    if(ar[k].win < min.win){
                        min = ar[k];
                    }
                    if(ar[k].win == min.win){
                        if(ar[k].GD < min.GD){
                            min = ar[k];
                        }
                    }
                }
            }
            for(int k = 1 ; k < i ; k++) {
                if(ar[k].Score > max.Score){
                    max = ar[k];
                }
                if(ar[k].Score == max.Score){
                    if(ar[k].win > max.win){
                        max = ar[k];
                    }
                    if(ar[k].win == max.win){
                        if(ar[k].GD > max.GD){
                            max = ar[k];
                        }
                    }
                }
            }
            for(int k = 1 ; k <= i ; k++){
                for(int u = k+1 ; u <= i ; u++){
                    if(ar[k].Score < ar[u].Score){

                    }

                }
            }*/
            System.out.println("First Team: " + ar[i-1].Name) ;
            System.out.println("Last Team: " + ar[1].Name);
            System.out.printf("%11s %3s %4s %4s %4s %4s %5s %5s\n","NAME","WIN","DRAW","LOST","GF","GA","GD","SCORE");
            for(int k = i-1 ; k >= 2 ; k--){
                System.out.printf("%11s %3d %4d %4d %4d %4d %5d %5d\n",ar[k].Name,ar[k].win,ar[k].draw,ar[k].lost,ar[k].GF,ar[k].GA,ar[k].GD,ar[k].Score);
            }
            System.out.printf("%11s %3d %4d %4d %4d %4d %5d %5d ",ar[1].Name,ar[1].win,ar[1].draw,ar[1].lost,ar[1].GF,ar[1].GA,ar[1].GD,ar[1].Score);
        }

    }
}

public class Main {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int q = 0;
        int z = 0;
        int n = in.nextInt();
        LeagueManager o1 = new LeagueManager();
        LeagueManager.TableDreawer d1 = o1.new TableDreawer();
        for (int i = 0; i < n; i++) {
            LeagueManager.Team c1 = o1.new Team();
            String name = in.next();
            c1.setName(name);
            o1.addteam(c1);
        }
        while (in.hasNext()) {
            String temp1 = in.next();
            String temp2 = in.next();
            int score1 = in.nextInt();
            int score2 = in.nextInt();
            for (int i = 1; i <= n; i++) {
                if(o1.ar[i].Name.equals(temp1)){
                        o1.ar[i].GF += score1;
                        o1.ar[i].GA += score2;
                        if (score1 > score2) {
                            o1.ar[i].win++;
                            o1.ar[i].Score += 4;
                        }
                        if (score2 > score1) {
                            o1.ar[i].lost++;
                            o1.ar[i].Score += 1 ;
                        }
                        if (score1 == score2) {
                            o1.ar[i].draw++;
                            o1.ar[i].Score += 2;
                        }

                }
                if(o1.ar[i].Name.equals(temp2)) {
                    o1.ar[i].GF += score2;
                    o1.ar[i].GA += score1;
                    if (score2 > score1) {
                        o1.ar[i].win++;
                        o1.ar[i].Score += 4 ;
                    }
                    if (score1 > score2) {
                        o1.ar[i].lost++;
                        o1.ar[i].Score += 1;
                    }
                    if (score1 == score2) {
                        o1.ar[i].draw++;
                        o1.ar[i].Score += 2;
                    }
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            o1.ar[i].GD = o1.ar[i].GF - o1.ar[i].GA ;
        }
        d1.TableDreawer();
    }
}