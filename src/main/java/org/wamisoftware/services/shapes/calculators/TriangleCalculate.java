package org.wamisoftware.services.shapes.calculators;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.models.Triangle;
import org.wamisoftware.services.shapes.Calculator;
import org.wamisoftware.services.shapes.ShapeType;
import org.springframework.stereotype.Service;

@Service
public class TriangleCalculate implements Calculator {
    @Override
    public ShapeType getTypeOf() {
        return ShapeType.TRIANGLE;
    }

    @Override
    public double calculateArea(ShapeRequest request) {
        return Triangle.getArea(request);
    }

    @Override
    public double calculatePerimeter(ShapeRequest request) {
        return Triangle.getPerimeter(request);
    }

    @Override
    public void validation(ShapeRequest request) {
        Triangle.validation(request);
    }
}
