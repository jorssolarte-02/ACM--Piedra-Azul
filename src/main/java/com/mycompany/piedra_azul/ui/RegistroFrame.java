package com.mycompany.piedra_azul.ui;

import com.mycompany.piedra_azul.domain.model.Rol;
import com.mycompany.piedra_azul.domain.service.UsuarioService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RegistroFrame extends JFrame {

    private final UsuarioService usuarioService;

    private JTextField txtNombreCompleto;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<Rol> cmbRol;

    public RegistroFrame(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        initComponents();
    }

    private void initComponents() {
        setTitle("ACM--PIEDRA AZUL - Registro");
        setSize(1100, 760);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(245, 248, 251));

        // TOP BAR
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(26, 165, 183));
        topBar.setPreferredSize(new Dimension(10, 70));
        topBar.setBorder(new EmptyBorder(0, 24, 0, 24));

        JLabel brand = new JLabel("ACM--PIEDRA AZUL");
        brand.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
        brand.setForeground(Color.WHITE);
        topBar.add(brand, BorderLayout.WEST);

        root.add(topBar, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        center.setOpaque(false);
        root.add(center, BorderLayout.CENTER);

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

        JLabel title = new JLabel("Registrar usuario", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(16, 122, 136));
        c.gridy = 0;
        card.add(title, c);

        JLabel info = new JLabel(
                "<html><div style='text-align:center;'>Completa los datos para crear una cuenta y selecciona el rol.</div></html>",
                SwingConstants.CENTER
        );
        info.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        info.setForeground(new Color(110, 120, 130));
        c.gridy = 1;
        card.add(info, c);

        // helper: label centrado
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Color labelColor = new Color(20, 25, 30);

        JLabel lblNombre = new JLabel("Nombre completo", SwingConstants.CENTER);
        lblNombre.setFont(labelFont);
        lblNombre.setForeground(labelColor);

        JLabel lblUser = new JLabel("Nombre de usuario", SwingConstants.CENTER);
        lblUser.setFont(labelFont);
        lblUser.setForeground(labelColor);

        JLabel lblPass = new JLabel("Contraseña", SwingConstants.CENTER);
        lblPass.setFont(labelFont);
        lblPass.setForeground(labelColor);

        JLabel lblRol = new JLabel("Rol", SwingConstants.CENTER);
        lblRol.setFont(labelFont);
        lblRol.setForeground(labelColor);

        Dimension fieldSize = new Dimension(520, 44);
        Insets fieldInsets = new Insets(0, 150, 10, 150);

        txtNombreCompleto = new JTextField();
        txtNombreCompleto.setPreferredSize(fieldSize);
        txtNombreCompleto.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));

        txtUsername = new JTextField();
        txtUsername.setPreferredSize(fieldSize);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));

        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(fieldSize);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 230, 240), 1, true),
                new EmptyBorder(10, 12, 10, 12)
        ));

        cmbRol = new JComboBox<>(Rol.values());
        cmbRol.setPreferredSize(new Dimension(520, 46));
        cmbRol.setMaximumSize(new Dimension(520, 46));
        cmbRol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbRol.setBackground(Color.WHITE);

        // nombre
        c.gridy = 2; c.insets = new Insets(22, 0, 6, 0);
        card.add(lblNombre, c);
        c.gridy = 3; c.insets = fieldInsets;
        card.add(txtNombreCompleto, c);

        // usuario
        c.gridy = 4; c.insets = new Insets(10, 0, 6, 0);
        card.add(lblUser, c);
        c.gridy = 5; c.insets = fieldInsets;
        card.add(txtUsername, c);

        // pass
        c.gridy = 6; c.insets = new Insets(10, 0, 6, 0);
        card.add(lblPass, c);
        c.gridy = 7; c.insets = fieldInsets;
        card.add(txtPassword, c);

        // rol
        c.gridy = 8; c.insets = new Insets(10, 0, 6, 0);
        card.add(lblRol, c);
        c.gridy = 9;
        c.insets = new Insets(0, 0, 18, 0); // <- no uses 150/150 aquí
        c.fill = GridBagConstraints.NONE;   // <- CLAVE: evita que se estire horizontal
        c.anchor = GridBagConstraints.CENTER;
        card.add(cmbRol, c);

        // vuelve a HORIZONTAL para lo que sigue
        c.fill = GridBagConstraints.HORIZONTAL;
        // buttons panel
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnGuardar.setForeground(new Color(16, 122, 136));
        btnGuardar.setBackground(new Color(26, 165, 183));
        btnGuardar.setOpaque(true);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder(14, 24, 14, 24));
        btnGuardar.setPreferredSize(new Dimension(220, 52));

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCancelar.setForeground(new Color(16, 122, 136));
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setOpaque(true);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(26, 165, 183), 1, true),
                new EmptyBorder(14, 24, 14, 24)
        ));
        btnCancelar.setPreferredSize(new Dimension(220, 52));

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 18, 0));
        buttons.setOpaque(false);
        buttons.add(btnGuardar);
        buttons.add(btnCancelar);

        c.gridy = 10;
        c.insets = new Insets(10, 18, 18, 18);
        card.add(buttons, c);

        center.add(card);

        btnGuardar.addActionListener(e -> registrarUsuario());
        btnCancelar.addActionListener(e -> dispose());

        setContentPane(root);
    }

    private void registrarUsuario() {
        String nombre = txtNombreCompleto.getText().trim();
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());
        Rol rol = (Rol) cmbRol.getSelectedItem();

        if (nombre.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            boolean creado = usuarioService.crearUsuario(username, password, nombre, rol);
            if (creado) {
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}