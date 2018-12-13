package train2;

public class TrainRunnableTest {
    public static void main(String[] args) {
        TrainRunnable trainRunnable = new TrainRunnable();//共享资源对象

        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
        new Thread(trainRunnable).start();
    }
}
