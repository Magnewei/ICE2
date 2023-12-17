package com.example.ice;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
public class DBConnector{

    // Database URL & database credentials.
   private static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11671048";
   private static final String USER = "sql11671048";
   private static final String PASS = "dUkWhlecP6";

   // Loads users into an ArrayList for the login() method.
    private List<User> loadUsers() throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT username, password FROM users";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            //Så længe der er flere rækker i databasen
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                users.add(new User(username,password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public Boolean createUser(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()){
            String line;
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters based on your CSV file columns and data types
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.executeUpdate();
                return true;
            }
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){

            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public User login(String username, String password) throws FileNotFoundException {
        List<User> users = loadUsers();
        for(User user : users) {
            if (user.getUsername().equals(username)  && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("No user with the username and/or password was found.");
        return null;
    }

}