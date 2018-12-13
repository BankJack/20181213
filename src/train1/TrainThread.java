package train1;

public class TrainThread extends Thread {
    private int ticket = 20; //20张票
    @Override
    public void run() {//每个线程要做的事情
        while (ticket > 0){
            String threadName = Thread.currentThread().getName(); //获取当前正在运行的线程的名称
            System.out.println("线程：" + threadName + "\t出票号" + ticket);
            ticket--;
            try {
                Thread.sleep(100); //当前线程休眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
