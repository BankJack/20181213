package train1;

public class TrainThreadTest {
    public static void main(String[] args) {
        //开启4个线程
        new TrainThread().start();
        new TrainThread().start();
        new TrainThread().start();
        new TrainThread().start();
    }
}
