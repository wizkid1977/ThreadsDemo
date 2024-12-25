package threads7_executors;

import java.util.List;
import java.util.concurrent.Callable;

public class SumWorker implements Callable<Long> {
    private int startIndex, endIndex;
    private List<Integer> array;

    public SumWorker(int startIndex, int endIndex, List<Integer> array) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = startIndex; i < endIndex ; i++) {
            sum += array.get(i);
        }
        return sum;
    }
}
