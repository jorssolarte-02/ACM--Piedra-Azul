package com.mycompany.piedra_azul.utils;

/**
 *
 * @author JORS SOLARTE
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

public final class RoundedBorder implements Border {
    private final int radius;
    private final Color color;
    private final int thickness;

    public RoundedBorder(int radius, Color color, int thickness) {
        this.radius = radius;
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int pad = Math.max(8, thickness + 6);
        return new Insets(pad, pad, pad, pad);
    }

    
    public Insets getBorderInsets(Component c, Insets insets) {
        Insets i = getBorderInsets(c);
        insets.top = i.top; insets.left = i.left; insets.bottom = i.bottom; insets.right = i.right;
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            int offs = thickness / 2;
            g2.drawRoundRect(x + offs, y + offs, w - thickness, h - thickness, radius, radius);
        } finally {
            g2.dispose();
        }
    }
}