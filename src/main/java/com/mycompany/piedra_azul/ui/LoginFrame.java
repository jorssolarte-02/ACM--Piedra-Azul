package com.mycompany.piedra_azul.ui;

import com.mycompany.piedra_azul.domain.model.Usuario;
import com.mycompany.piedra_azul.domain.service.UsuarioService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginFrame extends JFrame {

    private final UsuarioService usuarioService;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public LoginFrame(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        initComponents();
    }

    private void initComponents() {
        setTitle("ACM--PIEDRA AZUL - Inicio");
        setSize(1100, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(245, 248, 251)); // fondo claro

        // TOP BAR (teal)
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(26, 165, 183));
        topBar.setPreferredSize(new Dimension(10, 70));
        topBar.setBorder(new EmptyBorder(0, 24, 0, 24));

        JLabel brand = new JLabel("ACM--PIEDRA AZUL");
        brand.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
        brand.setForeground(Color.WHITE);
        topBar.add(brand, BorderLayout.WEST);

        root.add(topBar, BorderLayout.NORTH);

        // CENTER
        JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        root.add(center, BorderLayout.CENTER);

        // CARD NORMAL (SIN RoundedPanel)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(26, 34, 26, 34)
        ));
        card.setPreferredSize(new Dimension(1000, 580));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(8, 0, 8, 0);

        // Title
        JLabel title = new JLabel("Iniciar sesión", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(16, 122, 136));
        c.gridy = 0;
        card.add(title, c);

        // Texto corto (para que NO falle)
        JLabel info = new JLabel(
                "<html><div style='text-align:center;'>Acceso por roles. Inicia sesión o registra una cuenta.</div></html>",
                SwingConstants.CENTER
        );
        info.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        info.setForeground(new Color(110, 120, 130));
        c.gridy = 1;
        card.add(info, c);

        // Usuario label
        JLabel lblUser = new JLabel("Usuario", SwingConstants.CENTER);
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblUser.setForeground(new Color(20, 25, 30));
        c.gridy = 2;
        c.insets = new Insets(20, 0, 6, 0);
        card.add(lblUser, c);

        // Usuario field
        txtUsername = new JTextField();
        txtUsername.setPreferredSize(new Dimension(520, 44));
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));
        c.gridy = 3;
        c.insets = new Insets(0, 150, 12, 150);
        card.add(txtUsername, c);

        // Pass label
        JLabel lblPass = new JLabel("Contraseña", SwingConstants.CENTER);
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPass.setForeground(new Color(20, 25, 30));
        c.gridy = 4;
        c.insets = new Insets(10, 0, 6, 0);
        card.add(lblPass, c);

        // Pass field
        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(520, 44));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));
        c.gridy = 5;
        c.insets = new Insets(0, 150, 18, 150);
        card.add(txtPassword, c);

        // Button login
        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setForeground(new Color(16, 122, 136));
        btnLogin.setBackground(new Color(16, 122, 136));
        btnLogin.setOpaque(true);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(14, 24, 14, 24));
        btnLogin.setPreferredSize(new Dimension(360, 54));

        c.gridy = 6;
        c.insets = new Insets(8, 250, 10, 250);
        card.add(btnLogin, c);

        // Button register
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.setForeground(new Color(16, 122, 136));
        btnRegistrar.setBackground(Color.WHITE);
        btnRegistrar.setOpaque(true);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(26, 165, 183), 1, true),
                new EmptyBorder(12, 20, 12, 20)
        ));
        btnRegistrar.setPreferredSize(new Dimension(240, 48));

        c.gridy = 7;
        c.insets = new Insets(0, 300, 0, 300);
        card.add(btnRegistrar, c);

        // add card centered
        center.add(card);

        // Actions
        btnRegistrar.addActionListener(e -> new RegistroFrame(usuarioService).setVisible(true));
        btnLogin.addActionListener(e -> login());
        txtPassword.addActionListener(e -> login());

        setContentPane(root);
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Usuario usuario = usuarioService.autenticar(username, password);

            if (usuario == null) {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                txtPassword.setText("");
                return;
            }

            new MenuPrincipalFrame(usuario, usuarioService).setVisible(true);
            this.dispose();

        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}