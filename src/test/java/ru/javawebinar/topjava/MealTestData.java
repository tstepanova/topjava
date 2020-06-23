package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_MEAL_ID = START_SEQ + 2;
    public static final int ADMIN_MEAL_ID = START_SEQ + 9;

    public static final Meal USER_MEAL1 = new Meal(USER_MEAL_ID, of(2020, Month.JANUARY, 30, 10, 0), "Завтрак пользователя", 500);
    public static final Meal USER_MEAL2 = new Meal(USER_MEAL_ID + 1, of(2020, Month.JANUARY, 30, 13, 0), "Обед пользователя", 1000);
    public static final Meal USER_MEAL3 = new Meal(USER_MEAL_ID + 2, of(2020, Month.JANUARY, 30, 20, 0), "Ужин пользователя", 500);
    public static final Meal USER_MEAL4 = new Meal(USER_MEAL_ID + 3, of(2020, Month.JANUARY, 31, 00, 0), "Еда пользователя на граничное значение", 100);
    public static final Meal USER_MEAL5 = new Meal(USER_MEAL_ID + 4, of(2020, Month.JANUARY, 31, 10, 0), "Завтрак пользователя", 1000);
    public static final Meal USER_MEAL6 = new Meal(USER_MEAL_ID + 5, of(2020, Month.JANUARY, 31, 13, 0), "Обед пользователя", 500);
    public static final Meal USER_MEAL7 = new Meal(USER_MEAL_ID + 6, of(2020, Month.JANUARY, 31, 20, 0), "Ужин пользователя", 410);

    public static final Meal ADMIN_MEAL1 = new Meal(ADMIN_MEAL_ID, of(2020, Month.JANUARY, 30, 10, 0), "Завтрак админа", 500);
/*
    public static final Meal ADMIN_MEAL2 = new Meal(ADMIN_MEAL_ID + 1, of(2020, Month.JANUARY, 30, 13, 0), "Обед админа", 1000);
    public static final Meal ADMIN_MEAL3 = new Meal(ADMIN_MEAL_ID + 2, of(2020, Month.JANUARY, 30, 20, 0), "Ужин админа", 500);
    public static final Meal ADMIN_MEAL4 = new Meal(ADMIN_MEAL_ID + 3, of(2020, Month.JANUARY, 31, 00, 0), "Еда админа на граничное значение", 100);
    public static final Meal ADMIN_MEAL5 = new Meal(ADMIN_MEAL_ID + 4, of(2020, Month.JANUARY, 31, 10, 0), "Завтрак админа", 1000);
    public static final Meal ADMIN_MEAL6 = new Meal(ADMIN_MEAL_ID + 5, of(2020, Month.JANUARY, 31, 13, 0), "Обед админа", 500);
    public static final Meal ADMIN_MEAL7 = new Meal(ADMIN_MEAL_ID + 6, of(2020, Month.JANUARY, 31, 20, 0), "Ужин админа", 410);
*/

    public static final List<Meal> MEALS = Arrays.asList(USER_MEAL7, USER_MEAL6, USER_MEAL5, USER_MEAL4, USER_MEAL3, USER_MEAL2, USER_MEAL1);

    public static Meal getNew() {
        return new Meal(null, of(2020, Month.JANUARY, 31, 23, 15), "NewDescription", 1555);
    }

    public static Meal getUpdated() {
        return new Meal(USER_MEAL_ID, USER_MEAL1.getDateTime(), "UpdatedDescription", 330);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
