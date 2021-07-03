package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.geometry.Lattice;
import com.lyferise.marain.typography.visuals.Line;
import com.lyferise.marain.typography.visuals.VisualElement;

import java.awt.*;

public class LatticeVisual extends VisualElement {

    public LatticeVisual(
            final int x,
            final int y,
            final LatticeVisualSettings settings,
            final Color color,
            final Lattice lattice) {

        this.x = x;
        this.y = y;
        final var spacingX = settings.getSpacingX();
        final var spacingY = settings.getSpacingY();
        final var diameter = settings.getDiameter();

        final var rowCount = lattice.getRowCount();
        final var columnCount = lattice.getColumnCount();
        for (var rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            for (var columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                var value = lattice.getValue(rowIndex, columnIndex);
                add(new LatticePointVisual((2 - columnIndex) * spacingX, rowIndex * spacingY, diameter, color, value));
            }
        }

        final var points = lattice.getPath().getPoints();
        for (var i = 0; i < points.size() - 1; i++) {
            final var a = points.get(i);
            final var b = points.get(i + 1);
            if (a != null && b != null) {
                final var p1 = settings.getLatticePoint(a);
                final var p2 = settings.getLatticePoint(b);
                add(new Line(p1, p2, color));
            }
        }
    }
}