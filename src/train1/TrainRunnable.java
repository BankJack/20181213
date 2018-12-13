package train1;

public class TrainRunnable implements Runnable {

    private int ticket = 20; //20张票

    @Override
    public void run() {
        while (ticket > 0){
            String threadName = Thread.currentThread().getName(); //获取当前正在运行的线程的名称
            System.out.println("线程：" + threadName + "\t出票号" + ticket);
            ticket--;
        }
    }
}
