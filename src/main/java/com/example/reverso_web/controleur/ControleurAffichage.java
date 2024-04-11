package com.example.reverso_web.controleur;

import com.example.reverso_web.exception.DaoException;
import com.example.reverso_web.exception.MyException;
import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.dao.DaoProspect;
import com.example.reverso_web.model.entite.Client;
import com.example.reverso_web.model.entite.Prospect;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Le contrôleur pour l'affichage des données dans l'application.
 */
public class ControleurAffichage {

    /**
     * Initialise l'affichage avec le choix spécifié.
     *
     * @param choix le choix spécifié pour l'affichage.
     */
    public static void init(String choix) {
        Affichage affichage = new Affichage(choix);
        affichage.setVisible(true);
    }

    /**
     * Récupère tous les clients de la base de données.
     *
     * @return une liste de tous les clients.
     */
    public static ArrayList<Client> findAllClient() throws Exception {
            return DaoClient.findAll();
    }

    /**
     * Récupère tous les prospects de la base de données.
     *
     * @return une liste de tous les Prospects.
     */
    public static ArrayList<Prospect> findAllProspect() throws Exception {
        return DaoProspect.findAll();
    }


    /**
     * Démarre l'interface d'accueil.
     */
    public static void startAccueil() {
        ControleurAccueil.init();
    }
}
