package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();


        userService.createUsersTable();


        userService.saveUser("Алексей", "Грильков", (byte)86);

        userService.saveUser("Друже", "Обломов", (byte)36);

        userService.saveUser("Пабло", "Эскобар", (byte)25);

        userService.saveUser("Леонель", "Месси", (byte)40);



        List<User> us = userService.getAllUsers();
        System.out.println(us);


        userService.cleanUsersTable();


        userService.dropUsersTable();


    }
}
