package org.wamisoftware.services;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.controllers.dto.ShapeResponse;
import org.wamisoftware.services.shapes.Calculator;
import org.wamisoftware.services.shapes.ShapeType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculateService {

    private final Map<ShapeType, Calculator> definitionMap;

    public CalculateService(List<Calculator> serviceMap) {
        this.definitionMap = serviceMap.stream().collect(Collectors.toMap(Calculator::getTypeOf, calculator -> calculator));
    }

    public ShapeResponse calculate(ShapeRequest request) {
        Calculator calculator = definitionMap.get(request.getShapeType());
        calculator.validation(request);
        double perimeter = calculator.calculatePerimeter(request);
        double area = calculator.calculateArea(request);
        return new ShapeResponse(area, perimeter);
    }
}
