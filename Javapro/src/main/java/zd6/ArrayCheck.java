package zd6;

import java.util.Arrays;

public class ArrayCheck {
    public int[] cutArray(int[] in) {

        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] == 4) {
                return Arrays.copyOfRange(in, i + 1, in.length);
            }
        }
        throw new RuntimeException();
    }

    public boolean checkArray(int[] in) {

        int count1 = 0;
        int count4 = 0;
        for (int arr : in) {
            if (arr == 1) count1++;
            if (arr == 4) count4++;
        }

        return count1 > 0 && count4 > 0 && count1 + count4 == in.length;
    }
}
