package org.wamisoftware.services.shapes.calculators;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.models.Circle;
import org.wamisoftware.services.shapes.Calculator;
import org.wamisoftware.services.shapes.ShapeType;
import org.springframework.stereotype.Service;

@Service
public class CircleCalculate implements Calculator {
    @Override
    public ShapeType getTypeOf() {
        return ShapeType.CIRCLE;
    }

    @Override
    public double calculateArea(ShapeRequest request) {
        return Circle.getArea(request);
    }

    @Override
    public double calculatePerimeter(ShapeRequest request) {
        return Circle.getPerimeter(request);
    }

    @Override
    public void validation(ShapeRequest request) {
        Circle.validation(request);
    }
}
