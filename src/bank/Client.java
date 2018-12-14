package bank;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Account account = new Account();//共享资源
        //获取CPU可用核心数
        int processors = Runtime.getRuntime().availableProcessors();
        // System.out.println(processors);

        //创建固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(processors);

        //取款的线程
        Thread t1 = new Thread(() ->
                account.get(new BigDecimal(100))
                , "陈取款");
        Thread t2 = new Thread(() ->
                account.get(new BigDecimal(200))
                , "王取款");
        Thread t3 = new Thread(() ->
                account.add(new BigDecimal(200))
                , "张存款");

        Thread t4 = new Thread(()->
                account.add(new BigDecimal(100)),"李存款");

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);

        pool.shutdown();//关闭线程池
    }
}
