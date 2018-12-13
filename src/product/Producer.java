package product;

/**
 * 生产者
 */
public class Producer implements Runnable {

    //共享资源
    private Repository repository;

    public Producer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true){
            repository.produce();
        }
    }
}
