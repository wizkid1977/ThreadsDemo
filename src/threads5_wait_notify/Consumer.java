package threads5_wait_notify;

import java.util.Stack;

public class Consumer extends Thread{
    private Stack<Integer> nums;
    private String name;

    public Consumer(Stack<Integer> nums, String name) {
        this.nums = nums;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {
                synchronized (nums) {
                    while (nums.isEmpty()) {
                        nums.wait(); // make this thread wait until getting notified
                    }
                }
                System.out.println(name + " got the number " + nums.pop() + " from Producer");
                sleep((int)(Math.random()*800)+200);
            } catch (InterruptedException ignored) {}
        }
    }
}
