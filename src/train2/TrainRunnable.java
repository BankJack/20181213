package train2;

public class TrainRunnable implements Runnable {

    private int ticket = 20;

    @Override
    public void run() {
        while (ticket > 0)
            sellTicket();

    }

    public synchronized void sellTicket(){
        if (ticket > 0){ //获得资源的线程继续判断是否有余票
            String threadName = Thread.currentThread().getName(); //获取当前正在运行的线程的名称
            System.out.println("线程：" + threadName + "\t出票号" + ticket);
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
