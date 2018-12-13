package product;

public class Test {
    public static void main(String[] args) {
        Bread randomBread1 = Menu.getRandomBread();
        Bread randomBread2 = Menu.getRandomBread();
        Bread randomBread3 = Menu.getRandomBread();
        System.out.println(randomBread1);
        System.out.println(randomBread2);
        System.out.println(randomBread3);
    }
}
