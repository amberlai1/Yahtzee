/*
Group Members: Amber Lai, Bryce Berkhof, Alex de'Ath
NetIDs: alai8, bberkhof, adeath
Project 2: Throwdown
Due Date: 03/06/22
 */
// the first method, importing, and getters and setters were done by Amber and Bryce
import java.util.Scanner;
import java.util.Arrays;
public class test {
    // initializing our array - dice
    int[] dice = new int[5];

    public int[] getDice() {
        return dice;
    }
    public void setDice(int[] dice) {
        this.dice = dice;
    }

    public test() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
        }
    }
    // Alex did the DiceHand below method
    public test(int[] dice) {
        this.dice = dice;
    }
    // Amber and Bryce did the bestScore method
    public int bestScore() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        // makes copy of the diceHand array and sorts it from least to greatest
        int[] sortedHand = Arrays.copyOf(dice, 5);
        Arrays.sort(sortedHand);
        int[] outcomes = new int[12];
        // creates 12 different outcomes, based on the numbers in the array and will spit back largest outcome
        for (int n : sortedHand) {
            if (n == 1)
                count1++;
            if (n == 2)
                count2++;
            if (n == 3)
                count3++;
            if (n == 4)
                count4++;
            if (n == 5)
                count5++;
            if (n == 6)
                count6++;
        }
        if (count1 == 2)
            outcomes[0] = 2;
        if (count2 == 2)
            outcomes[1] = 4;
        if (count3 == 2)
            outcomes[2] = 6;
        if (count4 == 2)
            outcomes[3] = 8;
        if (count5 == 2)
            outcomes[4] = 10;
        if (count6 == 2) // if only 2 sixes, outcome 5 is equal to a score of 12
            outcomes[5] = 12;
        // three of a kind
        if (count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3 || count4 == 3 || count5 == 3 || count6 == 3) {
            outcomes[6] = sortedHand[0] + sortedHand[1] + sortedHand[2] + sortedHand[3] + sortedHand[4];
        }
        // four of a kind
        if (count1 == 4 || count2 == 4 || count3 == 4 || count4 == 4 || count4 == 4 || count5 == 4 || count6 == 4) {
            outcomes[7] = 10 + sortedHand[0] + sortedHand[1] + sortedHand[2] + sortedHand[3] + sortedHand[4];
        }
        // five of a kind
        if (count1 == 5 || count2 == 5 || count3 == 5 || count4 == 5 || count4 == 5 || count5 == 5 || count6 == 5) {
            outcomes[8] = 50 + sortedHand[0] + sortedHand[1] + sortedHand[2] + sortedHand[3] + sortedHand[4];
        }
        // small straight
        if (sortedHand[0] + 3 == sortedHand[3] && sortedHand[1] + 2 == sortedHand[3] && sortedHand[2] + 1 == sortedHand[3] ||
                sortedHand[1] + 3 == sortedHand[4] && sortedHand[2] + 2 == sortedHand[4] && sortedHand[3] + 1 == sortedHand[4] ||
                sortedHand[0] + 3 == sortedHand[4] && sortedHand[1] + 2 == sortedHand[4] && sortedHand[3] +1 == sortedHand[4]) {
            outcomes[9] = 30;
        }
        // large straight
        if (sortedHand[0] + 4 == sortedHand[4] && sortedHand[1] + 3 == sortedHand[4] && sortedHand[2] + 2 == sortedHand[4] &&
                sortedHand[3] + 1 == sortedHand[4]) {
            outcomes[10] = 40;
        }
        // full house
        if (sortedHand[0] == sortedHand[1] && sortedHand[2] == sortedHand[4] && sortedHand[3] == sortedHand[4] ||
                sortedHand[0] == sortedHand[1] && sortedHand[0] == sortedHand[2] && sortedHand[3] == sortedHand[4]) {
            outcomes[11] = 25;
        }
        Arrays.sort(outcomes); // sorts the outcomes from least to greatest
        return outcomes[11]; // returns the largest outcome which in turn should be the greatest score

    } public void doRerolls(int[] rerolls) {

        for (int i = 0; i < rerolls.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (rerolls[i] == dice[j]) {
                    dice[j] = (int) (Math.random() * 6) + 1;
                }
            }
        } System.out.println("");
        System.out.println("You Have Used Your One Chance at Reroll This Round.");
        System.out.println("Rerolling a value you do not have in your hand counts as one chance.");
        System.out.println("");
        setDice(dice);
        System.out.println(Arrays.toString(dice));

    }
    // Amber did the doRerolls
   /* public void doRerolls(int[] rerolls) {

        for (int i = 0; i < rerolls.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (rerolls[i] == dice[j]) {
                    dice[j] = (int) (Math.random() * 6) + 1;
                    break;
                }
            }
        }
        setDice(dice);
    }*/
    // Alex did the chooseRerolls method
    public int[] chooseRerolls() {
        return new int[0];

    } //Bryce did the toString
    public String toString() {
        return "Dice Hand: " + Arrays.toString(this.dice) + " " + "Score:" + bestScore();
    }

    // Amber did main method (test cases and
    public static void main(String[] args) {
        String input = "";
        System.out.println("Test Cases:");
        System.out.println("Please type in your test cases. (5 numbers separated only by spaces)");
        System.out.println("If you're done testing values, please write the word - quit -  to move onto the real game!");
        Scanner testCases = new Scanner(System.in);
        while (testCases.hasNextLine()) {
            input = testCases.nextLine();
            String[] cases = input.split(" ");
            if (input.contains("quit")) { //stops the program input and allows player to move on
                break;
            }
            int[] realtest = new int[cases.length];
            for (int i = 0; i < realtest.length; i++)
                realtest[i] = Integer.parseInt(cases[i]); // turns the string into an int into the array
            test lol = new test(realtest);
            System.out.println(lol);
        }
        // new rounds
        System.out.println("\t");
        System.out.println(" - Start of Rounds - ");
        System.out.println("\t");
        System.out.println("Welcome to our game! The game is now beginning");
        test round = new test();
        int sum = 0;
        Scanner newReroll = new Scanner(System.in); //scanner for the decision
        Scanner whatDice = new Scanner(System.in); //scanner for what dice to reroll
        String decision = "";
        for (int j = 1; j <= 10; j++) {
            round = new test(); //initializing new instance of DiceHand
            System.out.println("Round" + j + " " + round );
            System.out.println("Would you like to reroll?");
            decision = "";
            while (newReroll.hasNextLine()) {
                decision = newReroll.nextLine();
                if (decision.contains("yes")) {
                    System.out.println("What dice(s) would you like to reroll? (Enter with only spaces in between)");
                    String rerollValue = whatDice.nextLine();
                    String[] roll = rerollValue.split(" ");
                    int[] rerolls = new int[roll.length];
                    for (int i = 0; i < roll.length; i++) {
                        rerolls[i] = Integer.parseInt(roll[i]);
                        round.doRerolls(rerolls);
                    }
                    System.out.println("New" + " " + round);
                    break;
                }
                else if (decision.contains("no")) {
                    System.out.println("You have chosen not to reroll.");
                    break;
                }
            }
            sum = sum + round.bestScore();
        }
        System.out.println("Current Score:" + sum);
    }
}



