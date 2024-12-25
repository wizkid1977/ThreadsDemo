package threads7_executors;

import java.util.concurrent.Callable;

public class MyCalc implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        double result = 0;
        for (int i = 0; i < 100000; i++) {
            result = 1 + result * i;
        }
        return result;
    }
}
