package test1;

/**
 * 通过继承Thread类实现多线程
 */
public class ThreadExample2 {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }

    /**
     * 内部类，继承了Thread类
     */
    public static class MyThread extends Thread{
        //自定义的线程类，继承Thread后 ，必须重写父类中的run
        @Override
        public void run() {
           for (int i = 1;i <= 10;i++){
               System.out.println("线程的：" + i);
           }
        }
    }


}
