package sort;

import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        return (int)(o1.getPrice() - o2.getPrice());
    }
}
