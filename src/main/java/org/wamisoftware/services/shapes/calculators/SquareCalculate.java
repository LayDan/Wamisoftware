package org.wamisoftware.services.shapes.calculators;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.models.Square;
import org.wamisoftware.services.shapes.Calculator;
import org.wamisoftware.services.shapes.ShapeType;
import org.springframework.stereotype.Service;

@Service
public class SquareCalculate implements Calculator {

    @Override
    public ShapeType getTypeOf() {
        return ShapeType.SQUARE;
    }

    @Override
    public double calculateArea(ShapeRequest request) {
        return Square.getArea(request);
    }

    @Override
    public double calculatePerimeter(ShapeRequest request) {
        return Square.getPerimeter(request);
    }

    @Override
    public void validation(ShapeRequest request) {
        Square.validation(request);
    }
}
