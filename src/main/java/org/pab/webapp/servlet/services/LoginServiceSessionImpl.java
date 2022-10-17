package org.pab.webapp.servlet.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService{
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(); //obtenemos la sesion
        String username = (String) session.getAttribute("username");
        if (username!=null){
            return Optional.of(username);
        }
        return Optional.empty();
    }
}