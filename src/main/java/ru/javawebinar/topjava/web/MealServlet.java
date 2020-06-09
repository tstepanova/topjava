package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);
    private MealService mealController;

    @Override
    public void init() throws ServletException {
        mealController = new MealServiceImpl();
        initMeals();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer mealId = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : -1;

        Meal meal = new Meal(TimeUtil.of(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));
        if (mealId == -1) {
            mealController.add(meal);
        } else {
            meal.setId(mealId);
            mealController.update(meal);
        }
        response.sendRedirect("meals");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int mealId = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : -1;

        switch (action == null ? "view" : action) {
            case "add":
            case "update":
                Meal meal = action.equals("add") ?
                        new Meal(LocalDateTime.now(), "", 0) :
                        mealController.get(mealId);
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/meal_edit.jsp").forward(request, response);
                break;
            case "delete":
                mealController.delete(mealId);
                response.sendRedirect("meals");
                break;
            case "view":
            default:
                List<MealTo> meals = MealsUtil.filteredByStreams(
                        mealController.getAll(),
                        LocalTime.MIN,
                        LocalTime.MAX,
                        2000);
                request.setAttribute("meals", meals);
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }
    }

    private void initMeals() {
        for (Meal meal : MealsUtil.MEALS) {
            mealController.add(meal);
        }
    }
}
