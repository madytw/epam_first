package edu.training.first.entity;
import edu.training.first.exception.NotCircleException;

/**
 * Created by Roman on 21.09.2016.
 */
public class Circle {
    private Point centre;
    private int radius;

    public Circle(Point centre, int radius) throws NotCircleException {
        setCentre(centre);
        setRadius(radius);
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws NotCircleException {
        if(radius <= 0) throw new NotCircleException("It's not a circle!");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}
