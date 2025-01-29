package org.wamisoftware.models;

import org.junit.jupiter.api.Test;
import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;
import org.wamisoftware.services.shapes.ShapeType;

import static org.assertj.core.api.Assertions.*;

class SquareTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.SQUARE, 4., 0., 0., 0.);

        double expectedArea = 4 * 4;
        assertThat(Square.getArea(request)).isEqualTo(expectedArea);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.SQUARE, 4., 0., 0., 0.);

        double expectedPerimeter = 4 * 4;
        assertThat(Square.getPerimeter(request)).isEqualTo(expectedPerimeter);
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.SQUARE, null, 0., 0., 0.);

        assertThatThrownBy(() -> Square.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.SQUARE, -4., 0., 0., 0.);

        assertThatThrownBy(() -> Square.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenLengthIsZero() {
        ShapeRequest request = new ShapeRequest(ShapeType.SQUARE, 0., 0., 0., 0.);

        assertThatThrownBy(() -> Square.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be zero! Please use only positive values");
    }
}