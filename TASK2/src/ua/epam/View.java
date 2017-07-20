package ua.epam;


import java.util.Arrays;

/**
 * Created by Denis Starovoitenko on 19.07.2017.
 */
public class View {
    //Text constants
    public static final String HEADER = "**********************************";
    public static final String INFORMATION_DATE = "You need to guess the exist number in range ";
    public static final String WRONG_INPUT_DATA = "Wrong input data!!";

    /**
     * This method print message without adding new line to the end
     * @param message
     */
    public void printMessage(String message){
        System.out.print(message);
    }

    /**
     * This method print message with adding new line to the end
     * @param message
     */
    public void printlnMessage(String message){
        System.out.println(message);
    }

    /**
     * Print Range
     * @param digit1
     * @param digit2
     */
    public void printRange(int digit1, int digit2){
        printMessage(String.format("%s[ %d - %d ] :", View.INFORMATION_DATE, digit1, digit2));
    }

    /**
     * Print Warning
     */
    public void printWrongMessage(){
        printMessage(View.WRONG_INPUT_DATA + " ");
    }

    /**
     * If isSuccess = true print Congratulation, otherwise Help Information
     * @param isSuccess
     * @param number
     * @param array
     */
    public void printAdditionalMessage(boolean isSuccess, int number, int[] array){
        printlnMessage(View.HEADER);

        if (!isSuccess){
            printlnMessage("Last number : " + number);
            printlnMessage("All checked numbers : " + Arrays.toString(array));
        }
        else {
            printlnMessage("Congratulation!!! Required number: " + number);
            printlnMessage("Number of attempts: " + array.length + " : " + Arrays.toString(array));
        }
    }
}
