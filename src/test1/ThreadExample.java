package test1;

/**
 * 通过实现Runnable接口实现多线程
 */
public class ThreadExample {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();

        for (int i = 1;i <= 10;i++){
            System.out.println("主程序的：" + i);
            try {
                Thread.sleep(500); //每次循环线程休眠500毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test1() {
        Thread thread = new Thread(new Runnable() { //Runnable接口中只有一个方法，为run
            @Override
            public void run() { //多线程要做的事情都写在run方法中
                for (int i = 1; i <= 10; i++) {
                    System.out.println("线程中的：" + i);
                    try {
                        Thread.sleep(500); //每次循环线程休眠500毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();//开启线程


    }

    private static void test2(){
        //通过实例化Runnable接口的实现类的对象开启线程
        Thread thread = new Thread(new RunnableImpl());
        thread.start();//开启线程
    }

    private static void test3(){
        //通过lambda表达式实现
        Thread thread = new Thread(()->{  //（）代表run方法，{}中编写run方法的方法体
            for (int i = 1; i <= 10; i++) {
                System.out.println("线程中的：" + i);
                try {
                    Thread.sleep(500); //每次循环线程休眠500毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    /**
     * 自定义一个类，实现Runnable接口
     * 实现run方法
     */
    public static class RunnableImpl implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("线程中的：" + i);
                try {
                    Thread.sleep(500); //每次循环线程休眠500毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
