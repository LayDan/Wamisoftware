package org.wamisoftware.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShapeResponse {
    private double area;
    private double perimeter;
}