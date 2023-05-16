package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
        Connection connection = Util.getInstance().getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS Users (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(65)," +
                "lastName VARCHAR(65)," +
                "age TINYINT)";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String deleteTable = "DROP TABLE IF EXISTS  Users";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(deleteTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String addUser = "INSERT INTO Users (name, lastName, age) Values (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(addUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            int res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String deleteUserById = "DELETE FROM Users WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteUserById)) {
            preparedStatement.setLong(1, id);

            int res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        String getAllUsers = "SELECT * FROM Users";
        List<User> allUsers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAllUsers);



//            while (resultSet.next()) {
//                User user = new User();                                                            НЕ
//                user.setId(resultSet.getLong(1));   НЕТ КОНСТРУКТОРА ДЛЯ ID                    отображается
//                user.setName(resultSet.getString(2));                                              ИМЯ
//                user.setLastName(resultSet.getString(3));                                      пользователя
//                user.setAge(resultSet.getByte(4));
//
//                allUsers.add(user);
//            }
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                byte age = resultSet.getByte(4);
                User user = new User(name, lastName, age);
                user.setId(id);
                allUsers.add(user);

            }





//            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public void cleanUsersTable() {
        String cleanTable = "DELETE FROM Users";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(cleanTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
