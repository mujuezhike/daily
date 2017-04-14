package com.mujuezhike.daily;  
  
import java.math.BigInteger;
import java.util.ArrayList;  
import java.util.List;  
import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Future;  
import java.util.concurrent.FutureTask;  
  
public class ConcurrentCalculator {  
  
    private ExecutorService exec;  
    private int cpuCoreNumber;  
    private List<Future<Long>> tasks = new ArrayList<Future<Long>>();  
  
    // 内部类  
    class SumCalculator implements Callable<Long> {  
        private int[] numbers;  
        private int start;  
        private int end;  
  
        public SumCalculator(final int[] numbers, int start, int end) {  
            this.numbers = numbers;  
            this.start = start;  
            this.end = end;  
        }  
  
        public Long call() throws Exception {  
        	Long s= Feibo.fibonacci(BigInteger.valueOf(start)).longValue();
            
            return s;  
        }  
    }  
  
    public ConcurrentCalculator() {  
        cpuCoreNumber = Runtime.getRuntime().availableProcessors();  
        exec = Executors.newFixedThreadPool(cpuCoreNumber);  
    }  
  
    public Long sum(final int[] numbers) {  
        // 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor  
        for (int i = 0; i < cpuCoreNumber; i++) {  
            int increment = numbers.length / cpuCoreNumber + 1;  
            int start = 10;
            if(i>1){
            	start = 37;
            }
            int end = increment * i + increment;  
            if (end > numbers.length)  
                end = numbers.length;  
            SumCalculator subCalc = new SumCalculator(numbers, start, end);  
            FutureTask<Long> task = new FutureTask<Long>(subCalc);  
            tasks.add(task);  
            if (!exec.isShutdown()) {  
                exec.submit(task);  
            }  
        }  
        return getResult();  
    }  
  
    /** 
     * 迭代每个只任务，获得部分和，相加返回 
     *  
     * @return 
     */  
    public Long getResult() {  
        Long result = 0l;  
        for (Future<Long> task : tasks) {  
            try {  
                // 如果计算未完成则阻塞  
                Long subSum = task.get();  
                System.out.println(subSum);
                result += subSum;  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
    public void close() {  
        exec.shutdown();  
    }  
    
    public static void main(String[] args){
    	int[] numbers = new int[3];
    	
    	for(int i=0;i<numbers.length;i++){
    		
    		numbers[i] = i%66 - i%31;
    		
    	}
    	
    	ConcurrentCalculator cc = new ConcurrentCalculator();
    	System.out.println(cc.sum(numbers));
    	cc.close();
    }
}  