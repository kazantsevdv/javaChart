import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zd6.ArrayCheck;

public class test {
    ArrayCheck ach;

    @Before
    public void init() {
        ach = new ArrayCheck();
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{5, 6, 7, 8}, ach.cutArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{5, 6}, ach.cutArray(new int[]{2, 3, 4, 3, 2, 3, 4, 5, 6}));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[]{}, ach.cutArray(new int[]{1, 6, 4, 2, 6, 9, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void testexp() {

        ach.cutArray(new int[]{1, 2, 8, 6, 7, 8});
    }
}
