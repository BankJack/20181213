package train1;

/**
 * 测试类
 */
public class TrainRunnableTest {
    public static void main(String[] args) {
        TrainRunnable trainRunnable = new TrainRunnable();//共享的Runnable对象

        //开启4个线程
        /*
        * 观察结果，可以发现卖出的票有重复的
        * 导致重复票号的原因为，线程安全问题
        * */
        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
    }
}
