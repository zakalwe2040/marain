package com.lyferise.marain.typography.visuals;

import com.lyferise.marain.geometry.Point;
import lombok.Getter;

import java.awt.*;

@Getter
public class Line extends VisualElement {

    public Line(final Point a, final Point b, final Color color) {
        this.x = a.getX();
        this.y = a.getY();
        this.width = b.getX() - x;
        this.height = b.getY() - y;
        this.stroke = color;
    }

    @Override
    public void render(final int ox, final int oy, final VisualContext context) {
        final var graphics = context.getGraphics();
        graphics.setPaint(stroke);
        final var previous = graphics.getStroke();
        graphics.setStroke(new BasicStroke(4));
        graphics.drawLine(ox + x, oy + y, ox + x + width, oy + y + height);
        graphics.setStroke(previous);
    }
}