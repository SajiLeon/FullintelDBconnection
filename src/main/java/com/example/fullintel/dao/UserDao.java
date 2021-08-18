package com.example.fullintel.dao;

import com.example.fullintel.datasource.DataSource;
import com.example.fullintel.dto.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private static final String GET_USER_DETAILS = "SELECT Id, Email, FirstName, LastName FROM fullintel.user WHERE Email = ? AND Password = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO user(Email, FirstName, LastName) VALUES(?, ?, ?)";

    public List<User> selectAllUser(String email, String password) throws Exception {
        List<User> user = new ArrayList<>();

        try (Connection connection = DataSource.getConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(GET_USER_DETAILS)) {
                statement.setString(1, email);
                statement.setString(2, password);

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Integer userId = rs.getInt("Id");
                    String userEmail = rs.getString("Email");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");

                    user.add(new User(userId, userEmail, firstName, lastName));
                }
            }
        }
        return user;
    }


    public void insertUser() throws Exception {

        try (Connection connection = DataSource.getConnection()) {
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER)) {

                User user = new User();
                user.setEmail("sajeena.l@capestart.com");
                user.setFirstName("Sajeena");
                user.setLastName("Leon");
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());

                preparedStatement.executeUpdate();

            }
        }
    }
}


