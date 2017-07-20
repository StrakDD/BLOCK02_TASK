package ua.epam;

import java.util.Scanner;

/**
 * Created by Denis Starovoitenko on 19.07.2017.
 */
public class Controller {

    private int min = 0;
    private int max = 100;
    private NumberArray numberArray;

    //References to the model and view objects
    private Model model;
    private View view;

    //Constructor
    public Controller(Model model,View view){
        this.model = model;
        this.view = view;
        this.numberArray = new NumberArray();
    }

    //Main method that runs task
    public void processRun(){
        Scanner scanner = new Scanner(System.in);

        model.setNumber((int)(Math.random()*101));
        startGame(scanner);

        printSuccessMessage();
        scanner.close();
    }


    public void printFailureMessage(){
        view.printAdditionalMessage(false, numberArray.getLast(), numberArray.getArray());
    }

    public void printSuccessMessage(){
        view.printAdditionalMessage(true, model.getNumber(), numberArray.getArray());
    }

    public void printHelpMessage(){
        view.printWrongMessage();
        view.printRange(min, max);
    }

    /**
     * Check if input is digit and return it.
     * @param scanner
     * @return digit
     */
    public int getDigit(Scanner scanner){
        int result;

        view.printRange(min, max);
        while(!scanner.hasNextInt()){
            printHelpMessage();
            scanner.next();
        }

        result = scanner.nextInt();
        return result;
    }

    /**
     * Change searching range based on previous input number
     * @param scanner
     * @return
     */
    public int getDigitInRange(Scanner scanner){
        int digit = getDigit(scanner);

        while ( model.checkRange(min, max, digit)){
            //printHelpMessage();
            view.printWrongMessage();
            digit = getDigit(scanner);
        }

        return digit;
    }

    /**
     * Start Game More or Less
     * @param scanner
     */
    public void startGame(Scanner scanner){
        int digit = getDigitInRange(scanner);
        while(!model.guessNumber(digit)){
            if (digit > model.getNumber()){
                max = digit;
            }
            else {
                min = digit;
            }
            numberArray.insert(digit);
            printFailureMessage();
            digit = getDigitInRange(scanner);
        }
        numberArray.insert(digit);
    }
}
