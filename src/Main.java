import java.util.Scanner;

public class Main {
    public static void main (String args[]){
        Game2048 g = new Game2048();
        System.out.println("Punteggio giocatore: " + g.getScore() +  "\n");
        System.out.println(g.toString());
        while (!g.isLose()){

            Scanner in = new Scanner(System.in);
            String direction = in.nextLine();
            g.playerTurn(direction);
            System.out.println("Punteggio giocatore: " + g.getScore() +  "\n");
            if (g.isLose()){
                System.out.println("Hai perso!\n");
                break;
            }
            System.out.println(g.toString());
        }

    }
}