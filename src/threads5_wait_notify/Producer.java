package threads5_wait_notify;

import java.util.Stack;

public class Producer extends Thread{
    private Stack<Integer> nums;

    public Producer(Stack<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        while(true) {
            nums.push((int)(Math.random()*100)+1);
            System.out.println("Stack: " + nums.toString());
            synchronized (nums) {
                nums.notify(); // alert threads that are waiting to wake up
            }
            try {
                sleep((int)(Math.random()*200)+200);
            } catch (InterruptedException ignored) {}
        }
    }
}
