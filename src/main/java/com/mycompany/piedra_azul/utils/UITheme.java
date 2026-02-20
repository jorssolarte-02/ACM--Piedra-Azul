
package com.mycompany.piedra_azul.utils;

/**
 *
 * @author JORS SOLARTE
 */
import java.awt.Color;
import java.awt.Font;

public final class UITheme {
    private UITheme() {}

    // ===== Colores (paleta principal) =====
    public static final Color PRIMARY = new Color(26, 166, 183);      // #1AA6B7 (teal)
    public static final Color PRIMARY_DARK = new Color(19, 138, 152); // #138A98
    public static final Color BG = new Color(245, 247, 250);          // #F5F7FA (fondo)
    public static final Color SURFACE = Color.WHITE;                  // tarjetas
    public static final Color TEXT = new Color(31, 41, 55);           // #1F2937
    public static final Color MUTED = new Color(107, 114, 128);       // #6B7280
    public static final Color BORDER = new Color(226, 232, 240);      // #E2E8F0
    public static final Color DANGER = new Color(239, 68, 68);        // #EF4444

    // ===== Espaciados =====
    public static final int PAD_8 = 8;
    public static final int PAD_12 = 12;
    public static final int PAD_16 = 16;
    public static final int PAD_24 = 24;

    // ===== Fuentes =====
    public static final Font H1 = new Font("Segoe UI", Font.BOLD, 26);
    public static final Font H2 = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font BODY = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font BUTTON = new Font("Segoe UI", Font.BOLD, 14);

    // ===== Radio (esquinas redondeadas) =====
    public static final int RADIUS_12 = 12;
    public static final int RADIUS_16 = 16;
}