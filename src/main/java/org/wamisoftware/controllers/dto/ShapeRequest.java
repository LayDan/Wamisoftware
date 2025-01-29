package org.wamisoftware.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.wamisoftware.services.shapes.ShapeType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShapeRequest {

    private ShapeType shapeType;

    private Double length;

    private Double width;

    private Double height;

    private Double radius;
}
