package com.mycompany.piedra_azul.ui.panel;

import com.mycompany.piedra_azul.utils.RoundedBorder;
import com.mycompany.piedra_azul.utils.UITheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel extends JPanel {

    public AdminPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setOpaque(false);

        JLabel title = new JLabel("Panel Administrador");
        title.setFont(UITheme.H2);
        title.setForeground(UITheme.TEXT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));
        add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(3, 2, 16, 16));
        grid.setOpaque(false);

        grid.add(createCardButton("Crear usuarios"));
        grid.add(createCardButton("Editar usuarios"));
        grid.add(createCardButton("Auditoría"));
        grid.add(createCardButton("Desactivar usuarios"));
        grid.add(createCardButton("Consultar usuarios del sistema"));
        grid.add(new JLabel("")); // balance visual

        JPanel pad = new JPanel(new BorderLayout());
        pad.setOpaque(false);
        pad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pad.add(grid, BorderLayout.CENTER);

        add(pad, BorderLayout.CENTER);
    }

    private JButton createCardButton(String text) {
        JButton btn = new JButton("<html><div style='text-align:center;'>" + text + "</div></html>");
        btn.setFocusPainted(false);
        btn.setBackground(UITheme.SURFACE);
        btn.setForeground(UITheme.PRIMARY_DARK);
        btn.setFont(UITheme.H2);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(UITheme.RADIUS_16, UITheme.BORDER, 1),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));
        btn.setPreferredSize(new Dimension(260, 120));

        // Hover simple
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(238, 248, 250));
            }
            @Override public void mouseExited(MouseEvent e) {
                btn.setBackground(UITheme.SURFACE);
            }
        });

        return btn;
    }
}