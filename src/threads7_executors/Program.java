package threads7_executors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Program {
    public static void main(String[] args) throws IOException {

        // Single Thread Executor
//        singleThread();


        // FixedThreadPool + execute()
//        fixedThreadPool1();

//        countCharsInFiles();

        // FixedThreadPool + submit()
//        fixedThreadPool2();


//        useExternalThread();


		scheduledExecutor();


    }

    private static void singleThread() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        System.out.println("Hello!");
        executorService.shutdown();
    }

    private static void fixedThreadPool1() {
        ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 5; i++) {
            executorService2.execute(()-> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(j);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {}
                }
            });
        }
    }

    public static void countCharsInFiles() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long start = System.currentTimeMillis();
        String[] fileNames = {"example.txt","example2.txt","example3.txt","example4.txt"};
        Future<?>[] futures = new Future[4];
        int i = 0;
        for (String fileName: fileNames) {
            futures[i] = executorService.submit(()->{
                try(FileReader reader = new FileReader(fileName)){
                    int count = 0;
                    while(reader.read() != -1){
                        count++;
                    }
                    System.out.println("The file '" + fileName +"' has " + count + " chars!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            i++;
        }
        for (int j = 0; j < futures.length; j++) {
            try {
                futures[j].get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Took me " + (end-start) + " milliseconds to run");

        executorService.shutdown();
    }
    /*
        Create a program with a FixedThreadPool and an array of file names.
        Add a task (runnable) to open a file, read the file contents and print how many letters were counted.
     */

    private static void fixedThreadPool2() {
        ExecutorService executorService3 = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService3.submit(()->{
            System.out.println("Callable 1 is starting to run...");
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
                Thread.sleep(100);
            }
            return sum;
        });

        executorService3.execute(()->{
            System.out.println("Runnable 3 is starting to run...");
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
        });

        Future<String> future2 = executorService3.submit(()->{
            System.out.println("Callable 2 is starting to run...");
            for (int i = 0; i < 20; i++) {
                // כלום ושום דבר
                Thread.sleep(100);
            }
            return "All done!";
        });


        try {
            System.out.println(future.get());
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }


        executorService3.shutdown();
    }

    /*
        Create a program that uses a FixedThreadPool to calculate the factorial of all numbers in an
        int array (ex. {5, 7, 10, 12, 15})
        The calculations will run using callable tasks to the executor.
        Print each result when ready...
     */

    private static void useExternalThread() {
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= 100_000; i++) {
            nums.add(i);
        }

        long start = System.currentTimeMillis();
        long sum = 0;

        ExecutorService executorService4 = Executors.newFixedThreadPool(2);
        int size = nums.size();
        Future<Long> f1 = executorService4.submit(new SumWorker(0, size / 2, nums));
        Future<Long> f2 = executorService4.submit(new SumWorker(size / 2, size , nums));
//        Future<Long> f3 = executorService4.submit(new SumWorker(size / 6, size / 4, nums));
//        Future<Long> f4 = executorService4.submit(new SumWorker(size / 4, size / 2, nums));
//        Future<Long> f5 = executorService4.submit(new SumWorker(size / 2, size*5/8, nums));
//        Future<Long> f6 = executorService4.submit(new SumWorker(size*5/8, size*6/8, nums));
//        Future<Long> f7 = executorService4.submit(new SumWorker(size*6/8, size*7/8, nums));
//        Future<Long> f8 = executorService4.submit(new SumWorker(size*7/8, nums.size(), nums));

        try {
            sum += f2.get() + f1.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
        executorService4.shutdown();


        // "normal" loop for sum
//        for (int i = 0; i < nums.size(); i++) {
//            sum += nums.get(i);
//        }

        long end = System.currentTimeMillis();
        System.out.println(sum + ", it took: " + (end - start) + " millisecs");
    }

	public static void scheduledExecutor(){
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(()-> System.out.println("Hello"), 0, 1, TimeUnit.DAYS);
        //service.shutdown();
	}

}