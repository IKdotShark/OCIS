import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import static org.testng.Assert.*;

public class firstClassTest extends DataProviderTest {

    @Test(groups = "firstFigure")
    public void TestFirst() {
        double x = -2;
        double y = 1;
        boolean fst = firstClass.FirstFigure(x,y);
        Assert.assertEquals(fst, true);
    }

    @Test(groups = "firstFigure")
    public void TestSecond() {
        double x = 0;
        double y = 1;
        boolean sec = firstClass.SecondFigure(x,y);
        Assert.assertEquals(sec, true);
    }

    @Test(groups = "secondFigure")
    public void TestThird() {
        double x = 3;
        double y = 0;
        boolean thr = firstClass.ThirdFigure(x,y);
        Assert.assertEquals(thr, true);
    }

    @Test(groups = "secondFigure")
    public void TestFour() {
        double x = 1.999999999;
        double y = -1.00000001;
        boolean foh = firstClass.FourFigure(x,y);
        Assert.assertEquals(foh, true);
    }

    @Test(groups = "twoFigures")
    public void testAll_Square() {
        double x = 0;
        double y = 1;
        int all = firstClass.All_Square(x,y);
        Assert.assertEquals(all, 1);
    }

    @Test(dataProvider = "Data")
    public void All_Squares() throws IOException {
        double[][] data = arraysData();
        for (int i = 0; i < data.length; i++) {
            double[] dataOne = data[i];
            double expected = dataOne[2];
            int result = firstClass.All_Square(dataOne[0], dataOne[1]);
            Assert.assertEquals(result, expected);
        }
    }
}
