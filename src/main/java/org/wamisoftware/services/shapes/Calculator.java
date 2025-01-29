package org.wamisoftware.services.shapes;

import org.wamisoftware.controllers.dto.ShapeRequest;

public interface Calculator {

    ShapeType getTypeOf();

    double calculateArea(ShapeRequest request);

    double calculatePerimeter(ShapeRequest request);

    void validation(ShapeRequest request);
}
