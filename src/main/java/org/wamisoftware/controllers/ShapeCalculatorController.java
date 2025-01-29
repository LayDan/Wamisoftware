package org.wamisoftware.controllers;

import org.wamisoftware.controllers.dto.ShapeRequest;
import org.wamisoftware.controllers.dto.ShapeResponse;
import org.wamisoftware.services.CalculateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shape")
public class ShapeCalculatorController {

    private final CalculateService calculateService;

    public ShapeCalculatorController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @PostMapping("/calculate")
    public ShapeResponse calculate(@RequestBody ShapeRequest request) {
        return calculateService.calculate(request);
    }
}
