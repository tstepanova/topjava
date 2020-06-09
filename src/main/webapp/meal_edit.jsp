<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Подсчет калорий</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Моя еда</h2>
<section>
    <h2>${param.action == 'add' ? 'Добавление еды' : 'Редактирование еды'}</h2>
    <hr>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>Дата/время:</dt>
            <dd><input type="text" value="${TimeUtil.of(meal.dateTime)}" size=50 name="dateTime" required></dd>
        </dl>
        <dl>
            <dt>Описание:</dt>
            <dd><input type="text" value="${meal.description}" size=50 name="description" required></dd>
        </dl>
        <dl>
            <dt>Калории:</dt>
            <dd><input type="number" value="${meal.calories}" size=50 name="calories" required></dd>
        </dl>
        <button onclick="window.history.back()" type="button">Отменить</button>
        <button type="submit">Сохранить</button>
    </form>
</section>
</body>
</html>
