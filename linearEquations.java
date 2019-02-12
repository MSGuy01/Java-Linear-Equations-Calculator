import static java.lang.System.*;
import javax.swing.*;
import java.awt.FlowLayout;
//reminder: uninstall intellij idea ultimate and eclipse
//maybe make separate class for slope intercept equation- replace code
import java.util.Scanner;
import java.util.Random;
public class linearEquations{
    static int getGoing = 0;
    static int playAgain = 0;
    static int askAgainAgain = 0;
    static int askFinderModeAgain = 0;
    static String finderMode;
    static Scanner keyboard = new Scanner(in);
    static int askConversionAgain = 0;
    static boolean doIf = true;
    public static void main(String[] args) {
        out.println("Remember to make code to remove the 1 if its before a variable");
        profile myProfile = new profile();
        out.print("What is your first name? Type it here: ");
        myProfile.firstName = keyboard.next();
        out.print("What is your last name? Type it here: ");
        myProfile.lastName = keyboard.next();
        out.println("Welcome to Java Linear Equations Calculator, by Matthew Bevins, " + myProfile.firstName + " " + myProfile.lastName + "!");
        out.println("Type in two coordinate points, and the computer will tell you the equation in slope intercept form!");
        while (getGoing == 0) {
            out.print("Type start to start: ");
            String startGameInput = keyboard.next();
            if (startGameInput.equals("start")) {
                getGoing = 1;
            } else {
                getGoing = 0;
            }
        }
        while (playAgain == 0) {
            askAgainAgain = 0;
            while (askFinderModeAgain == 0) {
                out.print("Which kind of equation? Type 'si' for slope intercept, 'ps' for point slope, and 's' for standard. Type 'convert' for converting one equation to another kind of equation: ");
                finderMode = keyboard.next();
                if (finderMode.equals("si") || finderMode.equals("ps") || finderMode.equals("s") || finderMode.equals("convert")) {
                    askFinderModeAgain = 1;
                } else {
                    out.println("Please type a valid response.");
                    askFinderModeAgain = 0;
                }
            }
            if (finderMode.equals("si")) {
                askAgainAgain = 0;
                out.print("Type the first x value: ");
                float xOneInput = keyboard.nextFloat();
                out.print("Type the second x value: ");
                float xTwoInput = keyboard.nextFloat();
                out.print("Type the first y value: ");
                float yOneInput = keyboard.nextFloat();
                out.print("Type the second y value: ");
                float yTwoInput = keyboard.nextFloat();
                slopeIntercept slopeintercept = new slopeIntercept(xOneInput, yOneInput, xTwoInput, yTwoInput);
                if (slopeintercept.isFake) {
                    out.println(slopeintercept.getEquation());
                }
                else {
                    out.println("Equation: " + slopeintercept.getEquation());
                }
            }
            else if (finderMode.equals("ps")) {
                out.print("Enter an X value: ");
                float xOneInput = keyboard.nextFloat();
                out.print("Enter a Y value: ");
                float yOneInput = keyboard.nextFloat();
                out.print("Enter another X value: ");
                float xTwoInput = keyboard.nextFloat();
                out.print("Enter another Y value: ");
                float yTwoInput = keyboard.nextFloat();
                pointSlope pointslope = new pointSlope(xOneInput, yOneInput, xTwoInput, yTwoInput);
                if (pointslope.isFake) {
                    out.println(pointslope.getEquation());
                }
                else {
                    out.println("Equation: " + pointslope.getEquation());
                }
            }
            else if (finderMode.equals("s")) {
                out.print("Enter an X value: ");
                float xOneInput = keyboard.nextFloat();
                out.print("Enter a Y value: ");
                float yOneInput = keyboard.nextFloat();
                out.print("Enter another X value: ");
                float xTwoInput = keyboard.nextFloat();
                out.print("Enter another Y value: ");
                float yTwoInput = keyboard.nextFloat();
                standard standard = new standard(xOneInput, yOneInput, xTwoInput, yTwoInput);
                if (standard.isFake) {
                    out.println(standard.getEquation());
                }
                else {
                    out.println("Equation: " + standard.getEquation());
                }
            }
            else if (finderMode.equals("convert")) {
                askForConversion();
            }
            while (askAgainAgain == 0) {
                out.print(myProfile.firstName + ", would you like to enter another line? (type yes or no): ");
                String again = keyboard.next();
                if (again.equals("yes")) {
                    playAgain = 0;
                    askFinderModeAgain = 0;
                    askAgainAgain = 1;
                }
                else if (again.equals("no")) {
                        playAgain = 1;
                        askAgainAgain = 1;
                        out.println("Thanks for using this program!");
                }
                else {
                        askAgainAgain = 0;
                }
            }
        }
    }
    public static void askForConversion() {
        askConversionAgain = 0;
        out.println("Which conversion? Here are the choices: ");
        String converterChoice = "sips";
        while (askConversionAgain == 0) {
            doIf = true;
            out.println("Type 'sips' for slope intercept to point slope");
            out.println("Type 'sis' for slope intercept to standard");
            out.println("Type 'pssi' for point slope to slope intercept");
            out.println("Type 'pss' for point slope to standard");
            out.println("Type 'ssi' for standard to slope intercept");
            out.println("Type 'sps' for standard to point slope");
            out.print("Type your choice here: ");
            converterChoice = keyboard.next();
            if (converterChoice.equals("sips") || converterChoice.equals("sis") || converterChoice.equals("pssi") || converterChoice.equals("pss") || converterChoice.equals("ssi") || converterChoice.equals("sps")) {
                askConversionAgain = 1;
            }
            else {
                out.println("Please type a valid response.");
                askConversionAgain = 0;
            }

        }

        converter Converter = new converter(converterChoice);
        if (converterChoice.equals("sips") || converterChoice.equals("sis")) {
            out.print("Type 'whole' if the slope is a whole number. If it isn't, just type 'no': ");
            String wholeNumber = keyboard.next();
            int slope = 1;
            float slopeNum = 1;
            float slopeDen = 1;
            if (wholeNumber.equals("whole")) {
                out.print("Enter the slope: ");
                slope = keyboard.nextInt();
            }
            else {
                out.print("Enter the slope numerator: ");
                slopeNum = keyboard.nextFloat();
                out.print("Enter the slope denominator: ");
                slopeDen = keyboard.nextFloat();
            }
            out.print("Enter the y intercept: ");
            float yIntercept = keyboard.nextFloat();
            if (converterChoice.equals("sips")) {
                if (wholeNumber.equals("whole")) {
                    Converter.sips(slope, 1, yIntercept);
                }
                else {
                    Converter.sips(slopeNum, slopeDen, yIntercept);
                }
            }
            else{
                if (wholeNumber.equals("whole")) {
                    Converter.sis(slope, 1, yIntercept);
                }
                else {
                    Converter.sis(slopeNum, slopeDen, yIntercept);
                }
            }
        }
        else if (converterChoice.equals("pssi") || converterChoice.equals("pss")) {
            out.print("Type 'whole' if the slope is a whole number. If it isn't, just type 'no': ");
            String wholeNumber = keyboard.next();
            int slope = 1;
            double slopeNum = 1;
            double slopeDen = 1;
            if (wholeNumber.equals("whole")) {
                out.print("Enter the slope: ");
                slope = keyboard.nextInt();
            }
            else{
                out.print("Enter the slope numerator: ");
                slopeNum = keyboard.nextDouble();
                out.print("Enter the slope denominator: ");
                slopeDen = keyboard.nextDouble();
            }
            out.print("Enter a y value: ");
            double yOne = keyboard.nextDouble();
            out.print("Enter an x value: ");
            double xOne = keyboard.nextDouble();
            if (converterChoice.equals("pssi")) {
                if (wholeNumber.equals("whole")) {
                    Converter.pssi(xOne, yOne, slope, 1);
                }
                else{
                    Converter.pssi(xOne, yOne, slopeNum, slopeDen);
                }
            }
            else{
                if (wholeNumber.equals("whole")) {
                    Converter.pss(xOne, yOne, slope, 1);
                }
                else{
                    Converter.pss(xOne, yOne, slopeNum, slopeDen);
                }
            }
        }
        else if (converterChoice.equals("ssi") || converterChoice.equals("sps")) {
            out.print("Enter A (The value before 'x'): ");
            float aX = keyboard.nextFloat();
            out.print("Enter B (The value before 'y'): ");
            float bY = keyboard.nextFloat();
            out.print("Enter C (The value after the '=' sign): ");
            float C = keyboard.nextFloat();
            if (converterChoice.equals("ssi")) {
                Converter.ssi(aX, bY, C);
            }
            else{
                Converter.sps(aX, bY, C);
            }
        }
        out.println(Converter.result);
    }

}
class profile{
    String firstName;
    String lastName;
}

