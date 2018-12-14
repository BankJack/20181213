package lights;

public class Lights {
    private int state = 1;//1=红灯   2=黄灯  3=绿灯

    public synchronized void red(){
        //如果state!=1说明现在不到红灯亮
        while (state != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1;i <= 5;i++){
            System.out.println("红灯亮" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //黄灯亮
        state = 2;
        notifyAll(); //唤醒其他线程
    }

    public synchronized void yellow(){
        //如果state != 2 说明不到黄灯亮
        while (state !=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1;i <= 3;i++){
            System.out.println("黄灯亮" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //绿灯亮
        state = 3;
        notifyAll();
    }

    public synchronized void green(){
        //如果state != 3  ，说明不到绿灯亮
        while (state != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1;i <= 5;i++){
            System.out.println("绿灯亮" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //红灯亮
        state = 1;
        notifyAll();
    }
}
