package com.lyferise.marain.typography.visuals;

import lombok.Getter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.round;

@Getter
public class TextElement extends VisualElement {
    final String text;
    final Font font;
    final Rectangle2D bounds;

    public TextElement(
            final String text,
            final Color stroke,
            final Font font,
            final LayoutContext layoutContext) {

        this.text = text;
        this.stroke = stroke;
        this.font = font;
        this.bounds = layoutContext.getStringBounds(text, font);
        this.width = (int) bounds.getWidth();
        this.height = (int) bounds.getHeight();
    }

    @Override
    public void render(final int ox, final int oy, final VisualContext context) {
        final var graphics = context.getGraphics();
        graphics.setPaint(stroke);
        graphics.setFont(font);
        graphics.drawString(text, ox + x, oy + y - round(bounds.getY()));
    }
}