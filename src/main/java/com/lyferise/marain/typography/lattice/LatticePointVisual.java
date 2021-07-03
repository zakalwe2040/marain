package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.typography.visuals.Circle;
import com.lyferise.marain.typography.visuals.VisualElement;

import java.awt.*;

public class LatticePointVisual extends VisualElement {

    public LatticePointVisual(final int x, final int y, final int diameter, final Color color, final boolean value) {
        this.x = x;
        this.y = y;
        final var circle = new Circle(0, 0, diameter);
        if (value) {
            circle.setFill(color);
        } else {
            circle.setStroke(color.darker().darker().darker());
            circle.setX(1);
            circle.setY(1);
            circle.setDiameter(diameter - 2);
        }
        add(circle);
    }
}