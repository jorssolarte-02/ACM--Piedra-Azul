package com.mycompany.piedra_azul.main;

import com.mycompany.piedra_azul.domain.service.UsuarioService;
import com.mycompany.piedra_azul.infrastructure.persistence.UsuarioRepositorySQLite;
import com.mycompany.piedra_azul.ui.LoginFrame;

import javax.swing.*;

public class Piedra_azul {

    private static UsuarioService usuarioService;

    public static void main(String[] args) {
        // Look and Feel del sistema (mejor apariencia base)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Inicializar dependencias
        UsuarioRepositorySQLite repository = new UsuarioRepositorySQLite();
        usuarioService = new UsuarioService(repository);

        // Iniciar interfaz
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(usuarioService);
            loginFrame.setVisible(true);
        });
    }

    public static UsuarioService getUsuarioService() {
        return usuarioService;
    }
}