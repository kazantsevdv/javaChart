package zd6;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        ArrayCheck ach = new ArrayCheck();
        int[] inarray = {0, 2, 3, 1, 3, 2, 4, 2, 3, 2, 5, 6, 0};
        System.out.println(Arrays.toString(ach.cutArray(inarray)));
        int[] array1 = {1, 1, 4, 4};
        System.out.println(ach.checkArray(array1));
    }


}
