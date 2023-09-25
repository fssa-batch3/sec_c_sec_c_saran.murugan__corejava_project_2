package com.fssa.movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;
import com.fssa.letzshow.util.CustomLogger;
import com.fssa.movie.connection.GetConnection;
import com.fssa.movie.daoException.DAOExceptions;
import com.fssa.movie.model.User;

public class UserDAO {
   
	public static boolean registerUser(User users) throws DAOExceptions, SQLException {
		try (Connection connection = GetConnection.getConnection()) {
			String query = "INSERT INTO users (username, email, Phone_number, password) VALUES (?, ?, ?, ?)";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, users.getUsername());
				pst.setString(2, users.getEmail());
				pst.setString(3, users.getNumber());
				pst.setString(4, users.getPassword());

				int row = pst.executeUpdate();

				return (row > 0);

			}

		} catch (SQLException e) {
			throw new DAOExceptions(e);
		}
	}

    public static boolean updateUser(User user) throws DAOExceptions {
        try (Connection connection = GetConnection.getConnection()) {
            // Create update statement
            String updateQuery = "UPDATE users SET username=?, email=?, password=?,Phone_number=? WHERE user_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                // Set values for the prepared statement
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getNumber());
                preparedStatement.setInt(5, user.getUserid());

                // Execute update statement
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated == 0) {
                    throw new DAOExceptions("Failed to update the user in the database.");
                }
            }
            CustomLogger.info("User updated successfully");
        } catch (SQLException e) {
            // Handle any database-related errors
            throw new DAOExceptions("Database error occurred: " + e.getMessage(), e);
        }
        return true;
    }


    public static User getUserById(int id) throws DAOExceptions {
		User user = null;
		try (Connection connection = GetConnection.getConnection()) {
			String query = "SELECT * FROM users WHERE user_id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						user = new User();
						user.setUserid(rs.getInt("user_id"));
						user.setUsername(rs.getString("username"));
						user.setEmail(rs.getString("email"));
						user.setNumber(rs.getString("Phone_number"));
						user.setPassword(rs.getString("password"));
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOExceptions(e);
		}
		return user;
	}

	public static List<User> getAllUsers() throws DAOExceptions {
		List<User> userList = new ArrayList<>();
		try (Connection connection = GetConnection.getConnection()) {
			String query = "SELECT * FROM users";
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						User user = new User();
						user.setUserid(rs.getInt("user_id"));
						user.setUsername(rs.getString("username"));
						user.setEmail(rs.getString("email"));
						user.setNumber(rs.getString("Phone_number"));
						user.setPassword(rs.getString("password"));
						userList.add(user);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOExceptions(e);
		}
		return userList;
	}

	public static User loginUser(String email, String password) throws DAOExceptions {

		try (Connection con = GetConnection.getConnection()) {

			// SQL query to delete the user from the 'user' table.
			String query = "SELECT * FROM users WHERE email = ? AND password = ?";

			User users;
			// Prepares the SQL query with the user_id.
			try (PreparedStatement psmt = con.prepareStatement(query)) {

				// Sets the user_id in the PreparedStatement.
				psmt.setString(1, email);
				psmt.setString(2, password);

				// Executes the delete query.
				try (ResultSet rs = psmt.executeQuery()) {

					if (rs.next()) {
						users = new User();
						users.setUserid(rs.getInt("user_id"));
						users.setUsername(rs.getString("username"));
						users.setEmail(rs.getString("email"));
						users.setNumber(rs.getString("Phone_number"));
						users.setPassword(rs.getString("password"));
						return users;
					}
				}

			}
			return null;

		} catch (SQLException e) {
			throw new DAOExceptions(e.getMessage());
		}
	}
	public static void main(String[] args) throws DAOExceptions {
		UserDAO.getUserById(1);
	}
}
