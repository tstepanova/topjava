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
<hr/>
<a href="meals?&action=add">+ Добавить</a>
<hr/>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Дата/Время</th>
        <th>Описание</th>
        <th>Калории</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr mealColor="${meal.excess}">
            <td>${TimeUtil.of(meal.dateTime)}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?&action=update&id=${meal.id}"><img src="img/pencil.png"></a></td>
            <td><a href="meals?&action=delete&id=${meal.id}"><img src="img/delete.png"></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>