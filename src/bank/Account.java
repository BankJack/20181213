package bank;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 账户类，共享资源
 */
public class Account {
    //表示金钱最好使用BigDecimal实现
    private BigDecimal balance = new BigDecimal(0);

    //存款
    public synchronized void add(BigDecimal money){
        LocalTime time = LocalTime.now();//当前时间，时分秒
        String format = time.format(DateTimeFormatter.ofPattern("HH:mm:ss SSS"));
        String name = Thread.currentThread().getName();//获取线程名称

        this.balance = this.balance.add(money); //存款
        System.out.println(format + ":用户<" + name + ">存款" + money + "，操作成功，当前余额：" + this.balance);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //取款
    public synchronized void get(BigDecimal money){
        LocalTime time = LocalTime.now();//当前时间，时分秒
        String format = time.format(DateTimeFormatter.ofPattern("HH:mm:ss SSS"));
        String name = Thread.currentThread().getName();//获取线程名称
        if (this.balance.compareTo(money) < 0){
                System.err.println(format + ":用户<" + name + ">取款" + money + "，余额不足！");
                return;
        }

        this.balance = this.balance.subtract(money);
        System.err.println(format + ":用户<" + name + ">取款" + money + "，操作成功，当前余额：" + this.balance);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
