package task02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {
    private final UMarket market;
    private final ArrayList<T> foodstuffs;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }
    public void printFoodstuffs(){
//        int index = 1;
//        for (var food : foodstuffs){
//            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(),
//                    food.getProteins() ? "Да" : "Нет",
//                    food.getFats() ? "Да" : "Нет",
//                    food.getCarbohydrates() ? "Да" : "Нет");
//        }

        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                        index.getAndIncrement(),
                        food.getName(),
                        food.getProteins() ? "Да" : "Нет",
                        food.getFats() ? "Да" : "Нет",
                        food.getCarbohydrates() ? "Да" : "Нет"));
    }

    public void cardBalancing() {
    }
}
