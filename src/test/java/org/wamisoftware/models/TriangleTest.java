package org.wamisoftware.models;

import org.junit.jupiter.api.Test;
import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.exceptions.ValidationException;
import org.wamisoftware.services.shapes.ShapeType;


import static org.assertj.core.api.Assertions.*;

class TriangleTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 0., 6., 4., null);

        double expectedArea = 0.5 * 6 * 4;
        assertThat(Triangle.getArea(request)).isEqualTo(expectedArea);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., 6., 7., null);

        double expectedPerimeter = 5 + 6 + 7;
        assertThat(Triangle.getPerimeter(request)).isEqualTo(expectedPerimeter);
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, null, 6., 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenWidthIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., null, 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Width can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenHeightIsNull() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., 6., null, null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Height can not be empty! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenLengthIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, -5., 6., 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenWidthIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., -6., 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Width can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenHeightIsNegative() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., 6., -7., null);
        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Height can not be negative! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenLengthIsZero() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 0., 6., 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Length can not be zero! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenWidthIsZero() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., 0., 7., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Width can not be zero! Please use only positive values");
    }

    @Test
    void shouldThrowExceptionWhenHeightIsZero() {
        ShapeRequest request = new ShapeRequest(ShapeType.TRIANGLE, 5., 6., 0., null);

        assertThatThrownBy(() -> Triangle.validation(request))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Height can not be zero! Please use only positive values");
    }
}