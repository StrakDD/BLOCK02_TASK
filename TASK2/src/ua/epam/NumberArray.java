package ua.epam;

import java.util.Arrays;

/**
 * Created by Denis Starovoitenko on 20.07.2017.
 */

/**
 * Class that contains array of assumption numbers and additional methods to wort with it.
 */
public class NumberArray {
    private int count;
    private int lenght;

    private int[] array;

    public NumberArray(){
        this(1);
    }

    public NumberArray(int lenght){
        this.count = 0;
        this.lenght = lenght;
        this.array = new int[lenght];
    }

    public int getCount() {
        return count;
    }

    public int getLenght() {
        return lenght;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, count);
    }

    public void insert(int number){
        checkBoundary();
        array[count] = number;
        count++;
    }

    public int getLast(){
        if (count == 0) return 0;

        return array[count - 1];
    }

    public void checkBoundary(){
        if ( (count + 1) > lenght ) {
            int[] tmp = Arrays.copyOf(array, count);
            lenght = lenght * 2;
            array = Arrays.copyOf(tmp, lenght);
        }
    }
}
