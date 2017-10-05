package boyntonrl;

import java.util.*;

public class Lab5 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter a number to estimate Pi");
        String aNumStr = input.next();
        int aNum = Integer.parseInt(aNumStr);
        int underCircle = 0;
        double underCirclePercent;
        double pi;
        boolean isValid = true;
        int x, y;
        do {
            while (isValidInput(aNumStr)) {
                for (int i = 0; i < aNum; i++) {
                    x = r.nextInt(aNum);
                    y = r.nextInt(aNum);
                    if ((Math.pow(x, 2) + Math.pow(y, 2)) <= Math.pow(aNum, 2)) {
                        underCircle++;
                    }
                }
                underCirclePercent = (double) underCircle / aNum;
                pi = underCirclePercent * 4;
                System.out.println("Pi is estimated to be: " + pi);
                System.out.print("Do you want to generate a new estimate for Pi?");
                playAgain(input.next());
            }
        } while ()
    }
    public static String getValidNum (){
        boolean validInt = true;
        Scanner input = new Scanner (System.in);
        String aNum;
        while (validInt) {
            System.out.print("Enter a number to estimate Pi");
            aNum = input.next();
            for (int i = 0; i < aNum.length() && validInt; i++){
                if (!Character.isDigit(aNum.charAt(i))){
                    validInt = false;
                }
            }
            return aNum;
        }
    }
    public static boolean generateAgain(String args[]){
        Scanner input = new Scanner (System.in);
        String yOrN;
        boolean isYorN = false;
        boolean generateAgain = false;
        while (!isYorN) {
            System.out.print("Do you want to generate a new estimate for pi? (Y for yes) or (N for no): ");
            yOrN = input.next();
            if (yOrN.equalsIgnoreCase("Y") || yOrN.equalsIgnoreCase("N")) {
                isYorN = true;
            } else {
                System.out.println("Sorry I don't understand...");
            }
        }
        if (yOrN.equalsIgnoreCase("Y")){
            generateAgain = true;
        }
        return generateAgain;
    }
}
