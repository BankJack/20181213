package lights;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Lights lights = new Lights();//共享资源

        Thread red = new Thread(()-> lights.red());
        Thread yellow = new Thread(()-> lights.yellow());
        Thread green = new Thread(()-> lights.green());

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(red);
        pool.execute(yellow);
        pool.execute(green);

        pool.shutdown();//关闭线程池
    }
}
