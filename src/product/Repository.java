package product;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 共享资源，仓库类
 */
public class Repository {
    //仓库存储上限10
    private final int CAPACITY = 10;

    //队列，FIFO（先进先出）
    private BlockingQueue<Bread> queue = new ArrayBlockingQueue(CAPACITY);

    /**
     * 生产者生产的方法
     */
    public synchronized void produce(){
        while (queue.size() >= CAPACITY){ //当前库存大于100，则停止生产，等待消费者消费
            try {
                System.out.println("仓库达到存储上限，"+Thread.currentThread().getName()+"停止生产....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Bread bread = Menu.getRandomBread();
        boolean offer = queue.offer(bread);
        //System.out.println(Thread.currentThread().getName() + "正在生产...");
        System.out.println(Thread.currentThread().getName() + "生产了" + bread + ",当前库存：" + queue.size());
        try {
            Thread.sleep(100); //休眠一秒钟，模拟生产过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();//唤醒正在等待的线程
    }

    /**
     * 消费者消费的方法
     */
    public synchronized  void take(){
        //库存不足时，0 则消费者等待生产者生产
        while (queue.size() <= 3){
            try {
                System.err.println("库存不足消费，"+Thread.currentThread().getName()+"等待.....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Bread take = queue.take();
            //System.out.println(Thread.currentThread().getName() + "开始消费...");
            System.out.println(Thread.currentThread().getName() + "消费了：" + take + "，当前库存：" + queue.size());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyAll();//唤醒正在等待的线程
        }

    }
}
