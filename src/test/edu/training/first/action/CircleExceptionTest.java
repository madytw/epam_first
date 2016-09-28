package test.edu.training.first.action;
import edu.training.first.action.CircleAction;
import edu.training.first.entity.Circle;
import edu.training.first.entity.Point;
import edu.training.first.exception.InvalidDistanceException;
import edu.training.first.exception.NotCircleException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Roman on 26.09.2016.
 */
public class CircleExceptionTest {
    @Test (expected = NotCircleException.class)
    public void checkNotCircleException() throws NotCircleException{
       Circle circle = new Circle(new Point(2, 2), -3);
    }

    @Test (expected = InvalidDistanceException.class)
    public void checkInvalidDistanceException() throws NotCircleException, InvalidDistanceException{
        CircleAction action = new CircleAction();
        Circle circle = new Circle(new Point(3, 2), 3);
        boolean expected = true;
        boolean actual = action.checkPosition(circle, -4);
        Assert.assertEquals(expected, actual);
    }
}
