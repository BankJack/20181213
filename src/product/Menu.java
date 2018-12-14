package product;

/**
 * 面包清单
 */
public class Menu {
    private static Bread[] breads = {
            new Bread("手撕面包",10),
            new Bread("肉松面包",5),
            new Bread("奶油面包",7),
            new Bread("提子面包",5),
            new Bread("豆沙面包",5)
    };

    public static Bread getRandomBread(){
        int index = (int) (Math.random() * breads.length);
        try {
            return breads[index].clone(); //克隆一个面包
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
