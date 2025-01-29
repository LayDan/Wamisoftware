package org.wamisoftware.models;

import org.junit.jupiter.api.Test;
import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;
import org.wamisoftware.services.shapes.ShapeType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, 5., 3., 0., 0.);

        double expectedArea = 5 * 3;
        assertThat(Rectangle.getArea(request)).isEqualTo(expectedArea);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, 5., 3., 0., 0.);

        double expectedPerimeter = (5 + 3) * 2;
        assertThat(Rectangle.getPerimeter(request)).isEqualTo(expectedPerimeter);
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, null, 3., 0., 0.);

        assertThatThrownBy(() -> Rectangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenWidthIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, 5., null, 0., 0.);

        assertThatThrownBy(() -> Rectangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Width can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, -1., 3., 0., 0.);

        assertThatThrownBy(() -> Rectangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenWidthIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.RECTANGLE, 5., -3., 0., 0.);

        assertThatThrownBy(() -> Rectangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Width can not be negative! Please use only positive values");
    }
}