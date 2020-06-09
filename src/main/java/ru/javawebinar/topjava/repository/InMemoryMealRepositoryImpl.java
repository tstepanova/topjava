package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealRepositoryImpl implements MealRepository {

    private Map<Integer, Meal> mealsMap;
    private AtomicInteger id = new AtomicInteger();

    public InMemoryMealRepositoryImpl() {
        mealsMap = new ConcurrentHashMap<>();
    }

    public List<Meal> getAll() {
        return new ArrayList<>(mealsMap.values());
    }

    public Meal add(Meal meal) {
        int id = createID();
        meal.setId(id);
        mealsMap.put(id, meal);
        return meal;
    }

    public Meal get(int id) {
        return mealsMap.get(id);

    }

    public Meal update(Meal meal) {
        mealsMap.put(meal.getId(), meal);
        return meal;

    }

    public void delete(int id) {
        mealsMap.remove(id);
    }

    private int createID() {
        return id.getAndIncrement();
    }
}
