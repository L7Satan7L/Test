package com.example.test.service;

import com.example.test.dto.TaskResponse;
import org.springframework.stereotype.Service;

public interface CalculatorService {

    TaskResponse calculate(Double firstCoe, Double secondCoe, Double thirdCoe);

    TaskResponse instruction();
}
