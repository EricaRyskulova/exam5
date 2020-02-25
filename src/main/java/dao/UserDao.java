package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDao {
    private static HashMap<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setName("Karina");
        user1.setYearOfBirth(2001);
        user1.setGender("female");
        User user2 = new User();
        user2.setName("Erica");
        user2.setYearOfBirth(2001);
        user2.setGender("female");
        users.put(1, user1);
        users.put(2, user2);
    }

    public void getUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "select * from users";
        try (Connection connection = DB.connect) {
            return new ArrayList<User>(users.add(createUser()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        String SQL = "select * from users where id=?";
        Connection connecton;
        try (Connection connection = DB.connect();
             PreparedStatement statement = connecton.prepareStatement(SQL)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return User.builder()
                            .id(rs.getInt("ID"))
                            .name(rs.getString("NAME"))
                            .password(rs.getString("PASSWORD"))
                            .createdDate(rs.getTimestamp("CREATED_DATE"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByYearOfBirth(int yearOfBirth){
        String SQL = "select * from users where yearOfBirth = ?";
        Connection connection;
        try(Connection connection1 = DB.connect();
        PreparedStatement statement = connection.prepareStatement(SQL)){
    statement.setInt(1,yearOfBirth);
    try(ResultSet rs = statement.executeQuery()){
    if(rs.next(int i > 2000)){
        return User.builder()

    }
        }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
