package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public int plusService(int n1, int n2) {
        return n1 + n2;
    }

    public int minusService(int n1, int n2) {
        return n1 - n2;
    }

    public int multiplyService(int n1, int n2) {
        return n1 * n2;
    }


    public double divideService(int n1, int n2) {
        return (n1 * 1.0) / n2;
    }

    public boolean checkNum(Integer num) {
        return (num == null);
    }

}
