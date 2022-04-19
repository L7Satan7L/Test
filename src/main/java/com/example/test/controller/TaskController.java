package com.example.test.controller;

import com.example.test.dto.TaskResponse;
import com.example.test.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final CalculatorService calculatorService;

    public TaskController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public ResponseEntity<TaskResponse> instruction() {
        return ResponseEntity.ok(calculatorService.instruction());
    }

    @GetMapping("/{first},{second},{third}")
    public ResponseEntity<TaskResponse> answer(@PathVariable("first") double firstCoe, @PathVariable("second") double secondCoe,
                                               @PathVariable("third") double thirdCoe) {
        return ResponseEntity.ok(calculatorService.calculate(firstCoe, secondCoe, thirdCoe));
    }
}
