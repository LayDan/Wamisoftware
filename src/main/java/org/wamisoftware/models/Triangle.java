package org.wamisoftware.models;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;

public class Triangle {
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
        if (request.getWidth() == null) {
            throw new ValidationException("Width can not be empty! Please use only positive values");
        }
        if (request.getWidth() < 0) {
            throw new ValidationException("Width can not be negative! Please use only positive values");
        }
        if (request.getWidth() == 0) {
            throw new ValidationException("Width can not be zero! Please use only positive values");
        }
        if (request.getHeight() == null) {
            throw new ValidationException("Height can not be empty! Please use only positive values");
        }
        if (request.getHeight() < 0) {
            throw new ValidationException("Height can not be negative! Please use only positive values");
        }
        if (request.getHeight() == 0) {
            throw new ValidationException("Height can not be zero! Please use only positive values");
        }
    }

    public static double getArea(ShapeRequest request) {
        return 0.5 * request.getWidth() * request.getHeight();
    }

    public static double getPerimeter(ShapeRequest request) {
        return request.getHeight() + request.getLength() + request.getWidth();
    }
}
