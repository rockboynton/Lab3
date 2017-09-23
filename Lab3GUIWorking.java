package boyntonrl;

import javax.swing.*;

public class Lab3GUIWorking {
    public static void main(String args[]){
        String singleOrMarried = JOptionPane.showInputDialog(null, "Are you a single filer or married joint filer? " +
                "Input s for single or m for married: ");
        String strExpectedEarnedIncome = JOptionPane.showInputDialog(null, "What is you expected earned income for 2018 " +
                "expressed as a number with no commas? ");

        int intExpectedEarnedIncome = Integer.parseInt(strExpectedEarnedIncome);
        int taxBracketIncomesSingle[] = {0, 9325, 37950, 91900, 191650, 416700, 418400, 418401};
        double taxBracketRatesSingle[] = {.10, .15, .25, .28, .33, .35, .396};
        int estimatedTax = 0;

        if (singleOrMarried.equals("s")) {
            //JOptionPane.showMessageDialog(null, "Your estimated taxes that you will be required to pay by March 15, 2018 is " +
            //        estimatedTax);
            int index = 0;
            while (index < 8) {
                if (intExpectedEarnedIncome > taxBracketIncomesSingle[index]) {
                    int taxBracketDifference = taxBracketIncomesSingle[index + 1] - taxBracketIncomesSingle[index];
                    if (intExpectedEarnedIncome < taxBracketIncomesSingle[index + 1]) {
                        estimatedTax += (intExpectedEarnedIncome * taxBracketRatesSingle[index]);
                        index = 10;
                    } else {
                        estimatedTax += (taxBracketDifference * taxBracketRatesSingle[index]);
                    }
                }
                index += 1;
            }
            JOptionPane.showMessageDialog(null, "Your estimated taxes that you will be required to pay by March 15, 2018 is " +
                    estimatedTax);
        }

    }
}
