package com.lyferise.marain.typography.visuals;

import java.awt.*;

public class Circle extends VisualElement {

    public Circle(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        setDiameter(diameter);
    }

    public Circle(int x, int y, int diameter, Color fill) {
        this(x, y, diameter);
        this.fill = fill;
    }

    public void setDiameter(final int diameter) {
        this.width = diameter;
        this.height = diameter;
    }

    @Override
    public void render(final int ox, final int oy, final VisualContext context) {
        final var graphics = context.getGraphics();
        if (fill != null) {
            graphics.setPaint(fill);
            graphics.fillOval(ox + x, oy + y, width, height);
        }
        if (stroke != null) {
            graphics.setPaint(stroke);
            graphics.drawOval(ox + x, oy + y, width, height);
        }
    }
}