package boyntonrl;

import java.util.*;
import java.lang.*;

public class Lab4 {
    public static void main(String args []) {

//        int WEEKS_LEFT_MAX = 40;
        int WEEKS_LEFT;
//        int STARTING_AMOUNT_MAX = 5000;
        double STARTING_AMOUNT_LINEAR;
//        System.out.println(Math.random() + "AND" + STARTING_AMOUNT_LINEAR);

        Scanner input = new Scanner(System.in);
        double linearTotal;
        double exponentialTotal;
        double inheritanceDifference;
        double weeksLeftLoop;
        int weeks;
        int playAgain;
        int choice;

        do {
            WEEKS_LEFT = (int) (Math.random() * 40);
            STARTING_AMOUNT_LINEAR = (Math.random() * 5000);
            linearTotal = STARTING_AMOUNT_LINEAR;
            exponentialTotal  = 0.01;
            weeksLeftLoop = WEEKS_LEFT;
            weeks = 1;
            System.out.print("Suppose you have a wealthy uncle who gives you two options for your inheritance. He will" +
                    " add to your inheritance every weeks until he dies according to one of two schemes:\n" +
                    "1. Starting with a given amount ($0-5000), he will add that amount to your total inheritance every weeks, or\n" +
                    "2. Starting with one penny, he will double your inheritance every weeks.\n" +
                    "Enter which option you would prefer: ");
            choice = input.nextInt();
            while (exponentialTotal < linearTotal && weeksLeftLoop > 0) {
                linearTotal += STARTING_AMOUNT_LINEAR;
                exponentialTotal *= 2;
                System.out.println("Week " + weeks + "  Linear: $" + linearTotal + ", Exponential: $" + exponentialTotal);
                weeks++;
                weeksLeftLoop--;
            }
            if (weeksLeftLoop > 0){
                for (int weeksLeft = (int) weeksLeftLoop; weeksLeft > 0; weeksLeft--){
                    exponentialTotal *= 2;
                }
            }
            System.out.println();
            inheritanceDifference = Math.abs(linearTotal - exponentialTotal);
            if ((choice == 1 && linearTotal > exponentialTotal) || (choice == 0 && linearTotal < exponentialTotal)) {
                System.out.print("Your uncle dies after " + WEEKS_LEFT + " weeks so you got lucky and ended up with an extra $" +
                        inheritanceDifference);
            } else {
                System.out.print("Your uncle dies after " + WEEKS_LEFT + " weeks so you got unlucky and missed out on an extra $" +
                        inheritanceDifference);
            }
            System.out.println();
            System.out.println("Do you want to play again? (1 for yes) or (0 for no): ");
            playAgain = input.nextInt();
            System.out.println();
        } while (playAgain == 1);
//        System.out.format("Week %2d Linear: $%.2f\n", numberOfWeeks, linearAmount);
    }
}
/*
 *  Suppose you have a wealthy uncle who gives you two options for your inheritance. He will add to your inheritance
 *  every week until he dies according to one of two schemes:
 *
 *  Starting with a given amount (such as $5000), he will add that amount to your total inheritance every week, or
 *  Starting with one penny, he will double your inheritance every week.
 *  Option 2 will always outpace option 1 at some point in the future, but the question is when will option 2 be a better
 *  financial decision for you than option 1 and will it happen before your uncle dies?
 *
 *  For this lab you will be creating a game that explains the options briefly and allows a user to pick option 1 or option
  *  2. The starting amount for option 1 should be randomly generated (such as between $0 and $5000) each time the user plays the game.
  *  Also the number of remaining weeks of life for your uncle should be randomly generated (such as between 0 and 40 weeks).
 *
 *  You should display the value of the inheritance for each option, each week until either:
 *
 *  Option 2 exceeds option 1, or
 *  Your uncle dies
 *  You should tell the user whether they “won” or not and how much they won or lost. They win if they chose the option
 *  that causes them to end up with more money. They lose if they chose the option that leaves them with less money.
 *
 *  Lastly, you should give the user the option of playing the game again every time they see their results.
 */