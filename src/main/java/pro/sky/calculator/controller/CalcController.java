package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalcService;

@RestController
@RequestMapping("/calculator")
public class CalcController {

    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String hello() {
        return "Hi there, sweety!";
    }

    @GetMapping("/plus") // /plus?num1=1&num2=4
    public String plus(@RequestParam(value = "num1", required = false) Integer n1,
                       @RequestParam(value = "num2", required = false) Integer n2) {
        if (calcService.checkNum(n1) || calcService.checkNum(n2)) {
            return "Указаны не все параметры";
        } else {
            return n1 + " + " + n2 + " = " + calcService.plusService(n1, n2);
        }
    }

    @GetMapping("/minus") // /minus?num1=1&num2=4
    public String minus(@RequestParam(value = "num1", required = false) Integer n1,
                        @RequestParam(value = "num2", required = false) Integer n2) {
        if (calcService.checkNum(n1) || calcService.checkNum(n2)) {
            return "Указаны не все параметры";
        } else {
            return n1 + " - " + n2 + " = " + calcService.minusService(n1, n2);
        }
    }

    @GetMapping("/multiply") // /multiply?num1=1&num2=4
    public String multiply(@RequestParam(value = "num1", required = false) Integer n1,
                           @RequestParam(value = "num2", required = false) Integer n2) {
        if (calcService.checkNum(n1) || calcService.checkNum(n2)) {
            return "Указаны не все параметры";
        } else {
            return n1 + " * " + n2 + " = " + calcService.multiplyService(n1, n2);
        }
    }

    @GetMapping("/divide") // /divide?num1=1&num2=0
    public String divide(@RequestParam(value = "num1", required = false) Integer n1,
                         @RequestParam(value = "num2", required = false) Integer n2) {
        if (calcService.checkNum(n1) || calcService.checkNum(n2)) {
            return "Указаны не все параметры";
        } else if (n2 == 0) {
            return "Делить на ноль нельзя!";
        } else {
            return n1 + " / " + n2 + " = " + calcService.divideService(n1, n2);
        }
    }


}
