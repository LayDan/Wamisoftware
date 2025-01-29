package org.wamisoftware.models;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;

public class Square {

    /**
     * because square have all sides equals we can use constant
     */

    private final static Integer sides = 4;

    public static void validation(ShapeRequest request) {
        if (request.getLength() == null) {
            throw new ValidationException("Length can not be empty! Please use only positive values");
        }
        if (request.getLength() < 0) {
            throw new ValidationException("Length can not be negative! Please use only positive values");
        }
        if (request.getLength() == 0) {
            throw new ValidationException("Length can not be zero! Please use only positive values");
        }
    }

    public static double getArea(ShapeRequest request) {
        double a = request.getLength();
        return a * a;
    }

    public static double getPerimeter(ShapeRequest request) {
        return request.getLength() * sides;
    }
}
