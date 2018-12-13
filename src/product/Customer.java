package product;

/**
 * 消费者
 */
public class Customer implements Runnable{
    //共享资源
    private Repository repository;

    public Customer(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true){
            repository.take();
        }
    }
}
