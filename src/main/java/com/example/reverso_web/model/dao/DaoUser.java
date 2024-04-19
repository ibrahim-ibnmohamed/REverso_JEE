package com.example.reverso_web.model.dao;

import com.example.reverso_web.exception.DaoException;
import com.example.reverso_web.exception.MyException;
import com.example.reverso_web.model.entite.Prospect;
import com.example.reverso_web.model.entite.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoUser {



    // Méthode pour ajouter un nouvel utilisateur dans la base de données
    public static void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";

        try (  Connection connection = DaoConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour récupérer un utilisateur par son email
    public static User findByEmail(String email) throws SQLException {
        String query = "SELECT * FROM user WHERE email = ?";
        try (
                Connection connection = DaoConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Extraction des données du ResultSet pour créer un objet User
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    return new User(username, email, password);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Si aucun utilisateur trouvé, retourne null
        return null;
    }

    // Méthode pour mettre à jour les informations d'un utilisateur dans la base de données
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE user SET email = ? WHERE username = ?";
        try (
                Connection connection = DaoConnection.getConnection();PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour supprimer un utilisateur de la base de données
    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE username = ?";
        try (
                Connection connection = DaoConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
