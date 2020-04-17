import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import zd6.ArrayCheck;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2 {

    private final int[] in;
    boolean res;
    ArrayCheck ach;

    public Test2(int[] in, boolean res) {
        this.in = in;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4, 4}, false},
                {new int[]{4, 1, 4, 1, 6, 4}, false},
                {new int[]{4, 2, 4, 4, 1, 4}, false},
                {new int[]{1, 4, 1, 1, 1}, true},
                {new int[]{1, 4, 4, 4, 1}, true},
                {new int[]{1, 4, 1, 4, 1}, true},


        });
    }

    @Before
    public void init() {
        ach = new ArrayCheck();
    }


    @Test
    public void test() {

        Assert.assertEquals(res, ach.checkArray(in));
    }


}
