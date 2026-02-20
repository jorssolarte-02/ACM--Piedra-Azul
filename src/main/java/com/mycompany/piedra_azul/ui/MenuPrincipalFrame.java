package com.mycompany.piedra_azul.ui;

import com.mycompany.piedra_azul.domain.model.Usuario;
import com.mycompany.piedra_azul.domain.service.UsuarioService;
import com.mycompany.piedra_azul.ui.panel.*;
import com.mycompany.piedra_azul.utils.UIStyles;
import com.mycompany.piedra_azul.utils.UITheme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuPrincipalFrame extends JFrame {

    private final Usuario usuario;
    private final UsuarioService usuarioService;

    public MenuPrincipalFrame(Usuario usuario, UsuarioService usuarioService) {
        this.usuario = usuario;
        this.usuarioService = usuarioService;
        initComponents();
    }

    private void initComponents() {
        UIStyles.styleFrame(this, "ACM--PIEDRA AZUL - Menú principal");
        setSize(1100, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(UITheme.BG);

        // TopBar
        mainPanel.add(UIStyles.createTopBar("ACM--PIEDRA AZUL"), BorderLayout.NORTH);

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(UITheme.BG);
        header.setBorder(new EmptyBorder(16, 24, 8, 24));

        JLabel lblWelcome = new JLabel("Bienvenido: " + usuario.getNombreCompleto());
        lblWelcome.setFont(UITheme.H2);
        lblWelcome.setForeground(UITheme.TEXT);

        JLabel lblRole = new JLabel("Rol: " + usuario.getRol());
        lblRole.setFont(UITheme.BODY);
        lblRole.setForeground(UITheme.MUTED);

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.add(lblWelcome);
        left.add(Box.createVerticalStrut(4));
        left.add(lblRole);

        JButton btnCerrar = new JButton("Cerrar sesión");
        UIStyles.styleSecondaryButton(btnCerrar);
        btnCerrar.addActionListener(e -> {
            new LoginFrame(usuarioService).setVisible(true);
            this.dispose();
        });

        header.add(left, BorderLayout.WEST);
        header.add(btnCerrar, BorderLayout.EAST);

        mainPanel.add(header, BorderLayout.CENTER);

        // Panel rol dentro de card centrado
        JPanel rolePanel = obtenerPanelPorRol();
        rolePanel.setOpaque(false);

        var roleCard = UIStyles.wrapCard(rolePanel);
        roleCard.setPreferredSize(new Dimension(1000, 580));
        roleCard.setMaximumSize(new Dimension(1000, 580));

        JPanel roleCenter = new JPanel(new GridBagLayout());
        roleCenter.setBackground(UITheme.BG);
        roleCenter.setBorder(new EmptyBorder(10, 24, 24, 24));
        roleCenter.add(roleCard);

        // Centro real: header arriba + card centrada abajo
        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(UITheme.BG);
        center.add(header, BorderLayout.NORTH);
        center.add(roleCenter, BorderLayout.CENTER);

        mainPanel.add(center, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private JPanel obtenerPanelPorRol() {
        return switch (usuario.getRol()) {
            case ADMINISTRADOR -> new AdminPanel();
            case MEDICO_TERAPISTA -> new MedicoPanel();
            case PACIENTE -> new PacientePanel();
            case AGENDADOR -> new AgendadorPanel();
        };
    }
}