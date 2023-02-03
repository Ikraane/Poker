import cardutils.Card;
import ps.PsLogic;

import java.util.Scanner;

public class PsUserInterface {
    private PsLogic psLogic;
    private Scanner scan;

    public PsUserInterface() {
        this.psLogic = new PsLogic();
        this.scan = new Scanner(System.in);

    }

    public void run() {
        char choice = ' ';
        String answer;

        do {
            System.out.println("Enter choice N for NewGame and X for quit\n");
            answer = scan.nextLine();
            answer.toUpperCase();
            choice = answer.charAt(0);


            switch (choice) {
                case 'N':
                    newGame();
                    break;

                case 'X':
                    System.out.println("Bye, bye! See you soon!");
                    break;

                default:
                    System.out.println("Unknown command");
            }


        } while (choice != 'X');
    }

    public void newGame() {
        System.out.println("Initializing a new game ...");
        psLogic.initNewGame();
        System.out.println("Ready");

        while (!psLogic.isGameOver()) {
            pickACard();
        }
        System.out.println("GameOver!!!");
        System.out.println("You got " + psLogic.getPoints() + "points.");

    }


    public void pickACard() {
        Card nextCard = psLogic.pickNextCard();

        System.out.println("Choose where to " + "Place card: " + nextCard.toShortString());
        System.out.println("Select a pile [0....4]: ");


        System.out.println(psLogic.toString());


        String ans = scan.nextLine();
        int index = Integer.parseInt(ans.trim());
        psLogic.addCardToPile(index);
    }

}
