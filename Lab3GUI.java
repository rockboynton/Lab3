
package boyntonrl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3GUI {
    public static void main(String args[]) {
        String singleOrMarried = JOptionPane.showInputDialog(null, "Are you a single filer or married joint filer? " +
                "Input s for single or m for married: ");
        String strExpectedEarnedIncome = JOptionPane.showInputDialog(null, "What is you expected earned income for 2018 " +
                "expressed as a number with no commas? ");
        int intExpectedEarnedIncome = Integer.parseInt(strExpectedEarnedIncome);

        final int FIRST_BRACKET_INCOME_SINGLE = 9325;
        final int FIRST_BRACKET_INCOME_MARRIED = 18650;
        final int SECOND_BRACKET_INCOME_SINGLE = 37950;
        final int SECOND_BRACKET_INCOME_MARRIED = 75900;
        final int THIRD_BRACKET_INCOME_SINGLE = 91900;
        final int THIRD_BRACKET_INCOME_MARRIED = 153100;
        final int FOURTH_BRACKET_INCOME_SINGLE = 191650;
        final int FOURTH_BRACKET_INCOME_MARRIED = 233350;
        final int FIFTH_BRACKET_INCOME_SINGLE = 416700;
        final int FIFTH_BRACKET_INCOME_MARRIED = 416700;
        final int SIXTH_BRACKET_INCOME_SINGLE = 418400;
        final int SIXTH_BRACKET_INCOME_MARRIED = 470700;
        final int SEVENTH_BRACKET_INCOME_SINGLE = intExpectedEarnedIncome - 418401;
        final int SEVENTH_BRACKET_INCOME_MARRIED = intExpectedEarnedIncome - 470701;

        final double FIRST_BRACKET_RATE = 0.10;
        final double SECOND_BRACKET_RATE = 0.15;
        final double THIRD_BRACKET_RATE = 0.25;
        final double FOURTH_BRACKET_RATE = 0.28;
        final double FIFTH_BRACKET_RATE = 0.33;
        final double SIXTH_BRACKET_RATE = 0.35;
        final double SEVENTH_BRACKET_RATE = 0.396;

        double estimatedTax = 0.0;
        int taxBracketsSingle[] = new int[7];


        if (singleOrMarried.equals("s")) {
            if (intExpectedEarnedIncome > 0) {
                if (intExpectedEarnedIncome < FIRST_BRACKET_INCOME_SINGLE) {
                    estimatedTax += (intExpectedEarnedIncome * FIRST_BRACKET_RATE);
                    intExpectedEarnedIncome = -1;
                } else {
                    estimatedTax += (FIRST_BRACKET_INCOME_SINGLE * FIRST_BRACKET_RATE);
                    intExpectedEarnedIncome -= FIRST_BRACKET_INCOME_SINGLE;
                }
            }

            if (intExpectedEarnedIncome > FIRST_BRACKET_INCOME_SINGLE) {
                if (intExpectedEarnedIncome < SECOND_BRACKET_INCOME_SINGLE) {
                    estimatedTax += (intExpectedEarnedIncome * SECOND_BRACKET_RATE);
                    intExpectedEarnedIncome = -1;
                } else {
                    estimatedTax += ((SECOND_BRACKET_INCOME_SINGLE - FIRST_BRACKET_INCOME_SINGLE) * SECOND_BRACKET_RATE);
                    intExpectedEarnedIncome -= SECOND_BRACKET_INCOME_SINGLE;
                }
            }

            if (intExpectedEarnedIncome > SECOND_BRACKET_INCOME_SINGLE) {
                if (intExpectedEarnedIncome < THIRD_BRACKET_INCOME_SINGLE) {
                    estimatedTax += (intExpectedEarnedIncome * THIRD_BRACKET_RATE);
                    intExpectedEarnedIncome = -1;
                } else {
                    estimatedTax += (THIRD_BRACKET_INCOME_SINGLE * THIRD_BRACKET_RATE);
                    intExpectedEarnedIncome -= THIRD_BRACKET_INCOME_SINGLE;
                }
            }
            if (intExpectedEarnedIncome > THIRD_BRACKET_INCOME_SINGLE) {
                if (intExpectedEarnedIncome < FOURTH_BRACKET_INCOME_SINGLE) {
                    estimatedTax += (intExpectedEarnedIncome * FOURTH_BRACKET_RATE);
                    intExpectedEarnedIncome = -1;
                } else {
                    estimatedTax += (FOURTH_BRACKET_INCOME_SINGLE * FOURTH_BRACKET_RATE);
                    intExpectedEarnedIncome -= FOURTH_BRACKET_INCOME_SINGLE;
                }
            }
            JOptionPane.showMessageDialog(null, "Your estimated taxes that you will be required to pay by March 15, 2018 is " +
                    estimatedTax);

        }
    }
}