package test.edu.training.first.action;

import edu.training.first.action.CircleAction;
import edu.training.first.entity.Point;
import edu.training.first.exception.NotCircleException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Roman on 24.09.2016.
 */
@RunWith(Parameterized.class)
public class IsCircleTest {
    private static CircleAction action;
    private int radius;
    private boolean isCircle;

    public IsCircleTest(int radius, boolean isCircle) {
        this.radius = radius;
        this.isCircle = isCircle;
    }

    @Parameters
    public static Collection<Object[]> circleTableValues() {
        return Arrays.asList(new Object[][]{
                {5, true},  // radius > 0 - true
                {-5, false},  // radius < 0 - false
                {0, false},  // radius = 0 - false
        });
    }

    @BeforeClass
    public static void initCircleAction() {
        action = new CircleAction();
    }

    @Test
    public void isCircleTest() {
        boolean expected = this.isCircle;
        boolean actual = action.isCircle(radius);
        Assert.assertEquals(expected, actual);
    }
}
