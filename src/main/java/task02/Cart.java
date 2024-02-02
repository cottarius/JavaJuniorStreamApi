package task02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
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
        Optional<T> proteinFood =  foodstuffs.stream().filter(Food::getProteins).findFirst();
        Optional<T> fatFood =  foodstuffs.stream().filter(Food::getFats).findFirst();
        Optional<T> carbFood = foodstuffs.stream().filter(Food::getCarbohydrates).findFirst();

        if (proteinFood.isPresent() && fatFood.isPresent() && carbFood.isPresent()) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        if (proteinFood.isEmpty()) {
            proteinFood =  market.getThings(clazz).stream().filter(Food::getProteins).findFirst();
            proteinFood.ifPresent(foodstuffs::add);
        }
        if (fatFood.isEmpty()) {
            fatFood = market.getThings(clazz).stream().filter(Food::getFats).findFirst();
            fatFood.ifPresent(foodstuffs::add);
        }
        if (carbFood.isEmpty()) {
            carbFood = market.getThings(clazz).stream().filter(Food::getCarbohydrates).findFirst();
            carbFood.ifPresent(foodstuffs::add);
        }

        if (proteinFood.isPresent() && fatFood.isPresent() && carbFood.isPresent()) {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        }
    }
}
