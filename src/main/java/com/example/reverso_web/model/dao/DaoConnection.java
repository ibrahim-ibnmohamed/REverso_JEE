package com.example.reverso_web.model.dao;

import com.example.reverso_web.utilitaires.MyLogger;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * La classe {@code DaoConnection} est responsable de l'établissement de la connexion avec la base de données.
 * Elle utilise un fichier de propriétés pour obtenir les informations de connexion.
 */
public class DaoConnection {

    static Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DaoConnection.class.getName());
    private static final String FICHER_PROPERTIES_PATH = "/database.Properties";
    private static  Properties prop;
    static {
        try ( InputStream in = DaoConnection.class.getClassLoader().getResourceAsStream(FICHER_PROPERTIES_PATH)) {
            prop = new Properties();
            prop.load(in);

        }
        catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);

        }
    }
    /**
     * Méthode privée pour établir la connexion avec la base de données en utilisant les informations du fichier de propriétés.
     *
     * @throws SQLException  Si une erreur SQL se produit lors de l'établissement de la connexion.
     * @throws IOException   Si une erreur d'entrée/sortie se produit lors de la lecture du fichier de propriétés.
     */
    private static void connect() throws Exception {

       String url = getURL();
       String user =getUsername();
       String password = getPassword();

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
            MyLogger.LOGGER.log(Level.INFO,"Connexion à la base de données établie avec succès.");
       /* } catch (SQLException|IOException e) {
            MyLogger.LOGGER.log(Level.SEVERE, "Erreur lors de l'établissement de la connexion à la base de données", e);
            throw new SQLException("Erreur lors de l'établissement de la connexion à la base de données", e);
        }*/
    }
    /**
     * Méthode statique pour obtenir la connexion à la base de données.
     *
     * @return La connexion à la base de données.
     * @throws SQLException  Si une erreur SQL se produit lors de l'établissement de la connexion.
     * @throws IOException   Si une erreur d'entrée/sortie se produit lors de la lecture du fichier de propriétés.
     */
    public static Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {

                connect();
        }
        return connection;
    }

     public static String getURL(){
        return prop.getProperty("url");
     }
    public static String getUsername(){
        return prop.getProperty("username");
    }
    public static String getPassword(){
        return prop.getProperty("password");
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                if (connection != null) {
                    try {
                        connection.close();
                        MyLogger.LOGGER.info("Connexion à la base de données fermée avec succès.");
                    } catch (SQLException e) {
                        MyLogger.LOGGER.log(Level.SEVERE, "Erreur lors de la fermeture de la connexion à la base de données", e);
                    }
                }
            }
        });
    }
}
