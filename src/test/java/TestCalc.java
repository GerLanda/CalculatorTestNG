import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalc {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Тест запущен");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Тест заверщен");
    }

    @DataProvider
    public Object[][] sumTestEquals() {
        return new Object[][]{
                {10, 5, 5},
                {20, 10, 10},
                {0, -5, 5},
                {100, 70, 30},
                {0, 0, 0}
        };
    }

    @DataProvider
    public Object[][] diffTestEquals() {
        return new Object[][]{
                {0, 10, 10},
                {20, 40, 20},
                {-5, 5, 10},
                {1, 2, 1},
                {3, 10, 7}
        };
    }

    @DataProvider
    public Object[][] multiTestEquals() {
        return new Object[][]{
                {25, 5, 5},
                {21, 7, 3},
                {14, 7, 2},
                {100, 10, 10},
                {0, 0, 0}
        };
    }

    @DataProvider
    public Object[][] degTestEquals() {
        return new Object[][]{
                {5, 10, 2},
                {20, 40, 2},
                {3, 21,7},
                {6, 12, 2},
                {10, 100, 10}
        };
    }

    @DataProvider
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {10, 3, 5},
                {20, 15, 10},
                {1, -5, 5},
                {10, 70, 30},
                {6, 12, 15}
        };
    }

    @Test(dataProvider = "sumTestEquals")
    public void testEqualsSum(int sum, Object value1, Object value2) {
        Assert.assertEquals(sum,new Calc().sum(value1,value2), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsSumNegative(int sum, Object value1, Object  value2) {
        Assert.assertNotEquals(sum, new Calc().sum(value1,value2), "Значения равны!");
    }

    @Test(dataProvider = "diffTestEquals")
    public void testEqualsdiff(int diff, Object value1, Object value2) {
        Assert.assertEquals(diff, new Calc().diff(value1,value2), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsdiffNegative(int diff, Object value1, Object value2) {
        Assert.assertNotEquals(diff, new Calc().diff(value1,value2), "Значения равны!");
    }

    @Test(dataProvider = "multiTestEquals")
    public void testEqualsMulti(int multi, Object value1, Object value2) {
        Assert.assertEquals(multi, new Calc().multi(value1,value2), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsMultiNegative(int multi, Object value1, Object value2) {
        Assert.assertNotEquals(multi, new Calc().multi(value1,value2), "Значения равны!");
    }

    @Test(dataProvider = "degTestEquals")
    public void testEqualsDeg(int deg, Object value1, Object value2) {
        Assert.assertEquals(deg, new Calc().deg(value1,value2), "Значения не равны!");
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testEqualsDegNegative(int deg, Object value1, Object value2) {
        Assert.assertNotEquals(deg, new Calc().deg(value1,value2), "Значения равны!");
    }

    @DataProvider
    public Object[][] testObject() {
        return new Object[][]{
                {"string", 2, 2},
                {0, 9, "qwerty"},
                {10, "zxc", 4},
                {"abc", "0", 100},
                {9, null, 3}
        };
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObjectSum(Object sum, Object value1, Object value2) {
        Assert.assertEquals(sum, new Calc().sum(value1, value2), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObjectDiff(Object diff, Object value1, Object value2) {
        Assert.assertEquals(diff, new Calc().diff(value1, value2), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObjectMulti(Object multi, Object value1, Object value2) {
        Assert.assertEquals(multi, new Calc().multi(value1, value2), "Значения не равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObjectDef(Object deg, Object value1, Object value2) {
        Assert.assertEquals(deg, new Calc().deg(value1, value2), "Значения не равны!");
    }

}
