package org.wamisoftware.services.shapes.calculators;

import org.springframework.stereotype.Service;
import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.models.Rectangle;
import org.wamisoftware.services.shapes.Calculator;
import org.wamisoftware.services.shapes.ShapeType;

@Service
public class RectangleCalculate implements Calculator {

    @Override
    public ShapeType getTypeOf() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public double calculateArea(ShapeRequest request) {
        return Rectangle.getArea(request);
    }

    @Override
    public double calculatePerimeter(ShapeRequest request) {
        return Rectangle.getPerimeter(request);
    }

    @Override
    public void validation(ShapeRequest request) {
        Rectangle.validation(request);
    }
}
