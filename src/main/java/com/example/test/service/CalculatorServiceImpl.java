package com.example.test.service;

import com.example.test.dto.TaskResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public TaskResponse calculate(Double firstCoe, Double secondCoe, Double thirdCoe) {
        TaskResponse response = new TaskResponse();
        double firstRoot;
        double secondRoot;
        if(firstCoe.compareTo(0.0) == 0){
            firstRoot = -thirdCoe / secondCoe;
            response.setAnswer("equation has one root: " + firstRoot);
            return response;
        }
        Double d = Math.pow(secondCoe, 2) - 4 * firstCoe * thirdCoe;
        int compare = d.compareTo(0.0);
        if (compare < 0){
             response.setAnswer("equation has no roots");
        }
        if(compare == 0){
            firstRoot = -secondCoe / (2 * firstCoe);
            response.setAnswer("equation has one root: " + firstRoot);
        }
        if(compare > 0){
            firstRoot = (-secondCoe + Math.sqrt(d)) / (2 * firstCoe);
            secondRoot = (-secondCoe - Math.sqrt(d)) / (2 * firstCoe);
            response.setAnswer("equation has two root. One: " + firstRoot + " Two: " + secondRoot);
        }
        return response;
    }

    @Override
    public TaskResponse instruction() {
        return new TaskResponse("Enter three variables in the format '/a,b,c'");
    }
}
