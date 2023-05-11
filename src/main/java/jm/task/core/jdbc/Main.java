package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
//      Создание таблицы
        userService.createUsersTable();
//      Добавление User(ов)
//        userService.saveUser("Алексей", "Грильков", (byte) 86);
//        System.out.println("User с именем - " + user.getName() + "добавлен в базу данных");
//
//        userService.saveUser("Друже", "Обломов", (byte) 36);
//        System.out.println("User с именем - " + user.getName() + "добавлен в базу данных");
//
//        userService.saveUser("Пабло", "Эскобар", (byte) 25);
//        System.out.println("User с именем - " + user.getName() + "добавлен в базу данных");
//
//        userService.saveUser("Леонель", "Месси", (byte) 40);
//        System.out.println("User с именем - " + user.getName() + "добавлен в базу данных");
//      Получение всех User(ов) из базы и вывод в консоль


//      Очистка таблицы User(ов)

//      Удаление таблицы
    }
}
