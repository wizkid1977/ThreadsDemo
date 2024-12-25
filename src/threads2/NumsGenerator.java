package threads2;

import java.util.List;

public class NumsGenerator implements Runnable{
    private List<Integer> nums;

    public NumsGenerator(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //System.out.println(i);
            synchronized (nums) {
                nums.add((int) (Math.random() * 1000) + 1);
            }
        }
    }
}
