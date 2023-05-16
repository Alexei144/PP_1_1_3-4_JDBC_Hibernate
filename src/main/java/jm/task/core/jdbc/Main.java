package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
//        User user = new User();
//      Создание таблицы
//        userService.createUsersTable();

//      Добавление User(ов)
//        userService.saveUser("Алексей", "Грильков", (byte)86);
//
//        userService.saveUser("Друже", "Обломов", (byte)36);
//
//        userService.saveUser("Пабло", "Эскобар", (byte)25);
//
//        userService.saveUser("Леонель", "Месси", (byte)40);


//      Получение всех User(ов) из базы и вывод в консоль
//        List<User> us = userService.getAllUsers();
//        System.out.println(us);

//      Очистка таблицы User(ов)
//        userService.cleanUsersTable();

//      Удаление таблицы
        userService.dropUsersTable();


    }
}
