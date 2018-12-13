package test1;

public class SimpleExample {
    /**
     * 单线程
     * @param args
     */
    public static void main(String[] args) {
        Simple simple = new SimpleExample().new Simple();
        simple.run();

        for (int i = 1;i <= 10;i++){
            System.out.println("主程序的：" + i);
            try {
                Thread.sleep(500); //每次循环线程休眠500毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    class Simple{
        public void run(){
            for (int i = 1;i <= 10;i++){
                System.out.println("内部类的：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
