package org.wamisoftware.models;

import org.junit.jupiter.api.Test;
import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;
import org.wamisoftware.services.shapes.ShapeType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CircleTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.CIRCLE, 0., 0., 0., 5.0);
        double expectedArea = 3.14 * 5 * 5;
        assertThat(Circle.getArea(request)).isEqualTo(expectedArea);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.CIRCLE, 0., 0., 0., 5.0);

        double expectedPerimeter = 2 * 3.14 * 5;
        assertThat(Circle.getPerimeter(request)).isEqualTo(expectedPerimeter);
    }

    @Test
    void shouldThrowExceptionWhenRadiusIsNull() {
        ShapeRequest request = new ShapeRequest();

        assertThatThrownBy(() -> Circle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Radius can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenRadiusIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.CIRCLE, 0., 0., 0., -5.0);

        assertThatThrownBy(() -> Circle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Radius can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenRadiusIsZero() {
        ShapeRequest request = new ShapeRequest(ShapeType.CIRCLE, 0., 0., 0., 0.);

        assertThatThrownBy(() -> Circle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Radius can not be zero! Please use only positive values");
    }
}