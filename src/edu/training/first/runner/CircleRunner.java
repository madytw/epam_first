package edu.training.first.runner;
import edu.training.first.creator.CircleCreator;
import edu.training.first.entity.Circle;

import java.util.ArrayList;


/**
 * Created by Roman on 26.09.2016.
 */
public class CircleRunner {
    public static void main(String[] args){
        ArrayList<Circle> circles = new ArrayList<>();
        CircleCreator creator = new CircleCreator("data/data.txt");
        creator.testCircles(circles);
    }
}
