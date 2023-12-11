package com.example.ice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.*;
public class DBConnector{

    // database URL
    static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11669270";

    //  Database credentials
    static final String USER = "sql11669270";
    static final String PASS = "HreeKmVJuh";

    //Login i program med Username: "hej", Password: "lol".


    public List<User> loadUsers() throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT username, password FROM sql11669270.users";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            //Så længe der er flere rækker i databasen
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                 /*
                 int xp = resultSet.getInt("xp");
                 int level = resultSet.getInt("level");
                  */
                List<Datamon> list = null;

                users.add(new User(username,password));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void createUser(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()){
            String line;
            String insertQuery = "INSERT INTO sql11669270.users (username, password) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters based on your CSV file columns and data types
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                /*
                preparedStatement.setInt(3,0);
                preparedStatement.setInt(4,1);

                 */

                preparedStatement.executeUpdate();

            }
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
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