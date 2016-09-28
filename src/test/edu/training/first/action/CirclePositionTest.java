package test.edu.training.first.action;

import edu.training.first.action.CircleAction;
import edu.training.first.entity.Circle;
import edu.training.first.entity.Point;
import edu.training.first.exception.InvalidDistanceException;
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
 * Created by Roman on 21.09.2016.
 */

@RunWith(Parameterized.class)
public class CirclePositionTest {
    private static CircleAction action;
    private Circle circle;
    private boolean position;
    private int distance;

    public CirclePositionTest(int x, int y, int radius, int distance, boolean position) throws NotCircleException {
        this.circle = new Circle(new Point(x, y), radius);
        this.position = position;
        this.distance = distance;
    }

    @Parameters
    public static Collection<Object[]> circleTableValues() {
        return Arrays.asList(new Object[][]{
                // first quadrant
                {2, 2, 4, 2, false},  // crosses Ox and Oy - false
                {2, 2, 1, 1, false},  // crosses nothing - false
                {3, 2, 3, 1, true},  // crosses Ox, not Oy - true
                {2, 3, 3, 1, true},  // crosses Oy, not Ox - true
                // second quadrant
                {-2, 2, 4, 2, false},  // crosses Ox and Oy - false
                {-2, 2, 1, 1, false},  // crosses nothing - false
                {-3, 2, 3, 1, true},  // crosses Ox, not Oy - true
                {-2, 3, 3, 1, true},  // crosses Oy, not Ox - true
                // third quadrant
                {-2, -2, 4, 2, false}, // crosses Ox and Oy - false
                {-2, -2, 1, 1, false},  // crosses nothing - false
                {-3, -2, 3, 1, true},  // crosses Ox, not Oy - true
                {-2, -3, 3, 1, true},  // crosses Oy, not Ox - true
                // fourth quadrant
                {2, -2, 4, 2, false},  // crosses Ox and Oy - false
                {2, -2, 1, 1, false},  // crosses nothing - false
                {3, -2, 3, 1, true},  // crosses Ox, not Oy - true
                {2, -3, 3, 1, true}  // crosses Oy, not Ox - true
        });
    }

    @BeforeClass
    public static void initCircleAction() {
        action = new CircleAction();
    }

    @Test
    public void checkPositionTest() throws InvalidDistanceException{
        boolean expected = this.position;
        boolean actual = action.checkPosition(circle, distance);
        Assert.assertEquals(expected, actual);
    }
}
