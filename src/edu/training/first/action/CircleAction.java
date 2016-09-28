package edu.training.first.action;

import edu.training.first.entity.Circle;

import edu.training.first.exception.InvalidDistanceException;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * Created by Roman on 21.09.2016.
 */
public class CircleAction {

    public double circleSquare(Circle c) {
        return PI * pow(c.getRadius(), 2.0);
    }

    public double circlePerimeter(Circle c) {
        return 2 * PI * c.getRadius();
    }

    public boolean isCircle(int radius) {
        return radius > 0;
    }

    public boolean checkPosition(Circle c, int distance) throws InvalidDistanceException{
        if (distance < 0) throw new InvalidDistanceException("Invalid distance!");
        boolean checkOx = c.getRadius() >= distance + abs(c.getCentre().getY());
        boolean checkOy = c.getRadius() >= distance + abs(c.getCentre().getX());
        return checkOx ^ checkOy;
    }


}
