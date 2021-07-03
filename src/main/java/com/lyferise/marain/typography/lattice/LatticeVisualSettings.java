package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.geometry.Point;
import lombok.Value;

@Value
public class LatticeVisualSettings {
    int diameter = 6;
    int spacingX = 18;
    int spacingY = 16;

    public Point getLatticePoint(final Point p) {
        final var radius = diameter / 2;
        return new Point((2 - p.getX()) * spacingX + radius, p.getY() * spacingY + radius);
    }
}