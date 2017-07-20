package ua.epam;

/**
 * Created by Denis Starovoitenko on 19.07.2017.
 */
public class Model {
    private int number;

    //Setter and Getter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //Main logic of the Program

    /**
     * This method check input number for equality to exist number
     * @param number assumption numper
     * @return if guess number - true, otherwise - false
     */
    public boolean guessNumber(int number){
        return this.number == number;
    }

    /**
     * This method checks if digit is in some range
     * @param min
     * @param max
     * @param digit
     * @return
     */
    public boolean checkRange(int min, int max, int digit){
        return (digit < min) || (digit > max);
    }


}
