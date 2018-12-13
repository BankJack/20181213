package product;

public class Client {
    public static void main(String[] args) {
        Repository repository = new Repository();//共享资源

        Producer p = new Producer(repository);//生产者线程

        Customer c1 = new Customer(repository); //消费者线程
        Customer c2 = new Customer(repository); //消费者线程
        Customer c3 = new Customer(repository); //消费者线程

        new Thread(p,"面包王师傅").start();
        new Thread(c1,"顾客小朱").start();
        new Thread(c2,"顾客小陈").start();
        new Thread(c3,"顾客小李").start();
    }
}
