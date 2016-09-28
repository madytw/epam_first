package edu.training.first.creator;

import edu.training.first.action.CircleAction;
import edu.training.first.entity.Circle;
import edu.training.first.entity.Point;
import edu.training.first.exception.NotCircleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Roman on 26.09.2016.
 */
public class CircleCreator {
    private static final Logger LOG = LogManager.getLogger();
    private String fileName;

    public CircleCreator(String fileName) {
        this.fileName = fileName;
    }

    private void readCircles(ArrayList<Circle> circles) {
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            LOG.info("Reading file...");
            for(String s : stream.collect(Collectors.toList())) {
                try {
                    String[] params = s.split(" ");
                    Circle c = new Circle(new Point(Integer.parseInt(params[0]), Integer.parseInt(params[1])), Integer.parseInt(params[2]));
                    circles.add(c);
                }catch (NotCircleException e){
                    LOG.error(e);
                }catch (NumberFormatException e){
                    LOG.error(e);
                }
            }
        }catch (IOException e) {
            LOG.error(e);
        }
    }

    public void testCircles(ArrayList<Circle> circles){
        CircleAction action = new CircleAction();
        readCircles(circles);
        if(circles.isEmpty()) {
            LOG.info("No circles found.");
            return;
        }
        LOG.info("Testing...");
        for(Circle c: circles){
            LOG.info(c + " Perimeter: " + action.circlePerimeter(c) + "; " +
                    "Square: " + action.circleSquare(c));
        }
    }
}
