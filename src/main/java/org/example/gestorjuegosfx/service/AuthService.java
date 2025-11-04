package org.example.gestorjuegosfx.service;

import org.example.gestorjuegosfx.user.User;
import org.example.gestorjuegosfx.user.UserDAO;

import java.util.Optional;
import java.util.logging.Logger;

public class AuthService {

    private static Logger logger = Logger.getLogger(AuthService.class.getName());

    private UserDAO userDAO;
    private static User currentUser;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> login(String email, String password) {
        logger.info("Iniciando login");
        var user = userDAO.findByEmailAndPassword(email, password);

        if (user.isPresent()) {
            currentUser = user.get();
            logger.info("Login realizado com sucesso");
            return Optional.of(currentUser);
        }
        logger.info("Usuario no encontrado");
        return Optional.empty();
    }


    public void logout() {
        logger.info("Iniciando logout");
        currentUser = null;
    }

    public Optional<User> getCurentUser() {
        logger.info("Iniciando getCurentUser");
        return Optional.ofNullable(currentUser);
    }


}
