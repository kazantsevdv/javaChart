import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import zd6.ArrayCheck;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test1 {
    private final int[] in;
    private final int[] out;
    ArrayCheck ach;

    public Test1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 3, 2, 1}, new int[]{3, 2, 1}},
                {new int[]{6, 5, 4, 3, 2, 3, 4, 5, 67, 0}, new int[]{5, 67, 0}},
                {new int[]{1, 2, 2, 6, 8, 4}, new int[]{}},


        });
    }

    @Before
    public void init() {
        ach = new ArrayCheck();
    }


    @Test
    public void testAdd() {

        Assert.assertArrayEquals(out, ach.cutArray(in));
    }


}
