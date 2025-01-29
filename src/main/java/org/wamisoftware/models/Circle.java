package org.wamisoftware.models;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;

public class Circle {

    private final static Double p = 3.14;

    public static void validation(ShapeRequest request) {
        if (request.getRadius() == null) {
            throw new ValidationException("Radius can not be empty! Please use only positive values");
        }
        if (request.getRadius() < 0) {
            throw new ValidationException("Radius can not be negative! Please use only positive values");
        }
        if (request.getRadius() == 0) {
            throw new ValidationException("Radius can not be zero! Please use only positive values");
        }
    }

    public static double getArea(ShapeRequest request) {
        double radius_second_power = request.getRadius() * request.getRadius();
        return p * radius_second_power;
    }

    public static double getPerimeter(ShapeRequest request) {
        return 2 * p * request.getRadius();
    }
}
