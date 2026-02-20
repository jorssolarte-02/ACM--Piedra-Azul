package com.mycompany.piedra_azul.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonUI;

public final class UIStyles {
    private UIStyles() {}

    public static void styleFrame(JFrame frame, String title) {
        frame.setTitle(title);
        frame.getContentPane().setBackground(UITheme.BG);
    }

    public static JPanel createTopBar(String brandText) {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(UITheme.PRIMARY);
        topBar.setPreferredSize(new Dimension(10, 70));
        topBar.setBorder(BorderFactory.createEmptyBorder(0, UITheme.PAD_24, 0, UITheme.PAD_24));

        JLabel brand = new JLabel(brandText);
        brand.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD | java.awt.Font.ITALIC, 26));
        brand.setForeground(Color.WHITE);

        topBar.add(brand, BorderLayout.WEST);
        return topBar;
    }

    public static RoundedPanel wrapCard(JComponent content) {
        RoundedPanel card = new RoundedPanel(UITheme.RADIUS_16, UITheme.SURFACE);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(UITheme.RADIUS_16, UITheme.BORDER, 1),
                BorderFactory.createEmptyBorder(UITheme.PAD_24, UITheme.PAD_24, UITheme.PAD_24, UITheme.PAD_24)
        ));
        card.add(content, BorderLayout.CENTER);
        return card;
    }

    // Inputs estables
    public static void styleTextField(JTextField field) {
        field.setFont(UITheme.BODY);
        field.setBackground(Color.WHITE);
        field.setForeground(UITheme.TEXT);
        field.setCaretColor(UITheme.TEXT);

        field.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(UITheme.RADIUS_12, UITheme.BORDER, 1),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        Dimension d = new Dimension(520, 44);
        field.setPreferredSize(d);
        field.setMinimumSize(d);
        field.setMaximumSize(d);
    }

    public static void stylePasswordField(JPasswordField field) {
        styleTextField(field);
    }

    // Botones (no los pisa el Look&Feel)
    public static void stylePrimaryButton(JButton btn) {
        btn.setUI(new BasicButtonUI());

        btn.setFont(UITheme.BUTTON);
        btn.setForeground(Color.WHITE);
        btn.setBackground(UITheme.PRIMARY);

        btn.setOpaque(true);
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(true);
        btn.setFocusPainted(false);

        btn.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(UITheme.RADIUS_12, UITheme.PRIMARY_DARK, 1),
                BorderFactory.createEmptyBorder(12, 22, 12, 22)
        ));

        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void styleSecondaryButton(JButton btn) {
        btn.setUI(new BasicButtonUI());

        btn.setFont(UITheme.BUTTON);
        btn.setForeground(UITheme.PRIMARY_DARK);
        btn.setBackground(UITheme.SURFACE);

        btn.setOpaque(true);
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(true);
        btn.setFocusPainted(false);

        btn.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(UITheme.RADIUS_12, UITheme.PRIMARY, 1),
                BorderFactory.createEmptyBorder(12, 22, 12, 22)
        ));

        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void styleTitle(JLabel lbl) {
        lbl.setFont(UITheme.H1);
        lbl.setForeground(UITheme.PRIMARY_DARK);
    }

    public static void styleMuted(JLabel lbl) {
        lbl.setFont(UITheme.BODY);
        lbl.setForeground(UITheme.MUTED);
    }
}