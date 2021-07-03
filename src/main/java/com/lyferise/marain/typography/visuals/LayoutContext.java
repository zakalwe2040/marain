package com.lyferise.marain.typography.visuals;

import lombok.Value;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static java.awt.RenderingHints.KEY_FRACTIONALMETRICS;
import static java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_ON;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@Value
public class LayoutContext {
    BufferedImage image;
    Graphics2D graphics;
    FontMetrics fontMetrics;

    public LayoutContext() {
        image = new BufferedImage(1, 1, TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(KEY_FRACTIONALMETRICS, VALUE_FRACTIONALMETRICS_ON);
        fontMetrics = graphics.getFontMetrics();
    }

    public Rectangle2D getStringBounds(final String text, final Font font) {
        graphics.setFont(font);
        return fontMetrics.getStringBounds(text, graphics);
    }
}