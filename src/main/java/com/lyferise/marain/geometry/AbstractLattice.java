package com.lyferise.marain.geometry;

public abstract class AbstractLattice implements Lattice {

    @Override
    public boolean hasHorizontalSymmetry() {
        final var rowCount = getRowCount();
        final var columnCount = getColumnCount();
        final var n = rowCount / 2;
        for (var r = 0; r < n; r++) {
            final var r2 = rowCount - 1 - r;
            for (var c = 0; c < columnCount; c++) {
                if (getValue(r, c) != getValue(r2, c)) return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasVerticalSymmetry() {
        final var rowCount = getRowCount();
        final var columnCount = getColumnCount();
        final var n = columnCount / 2;
        for (var c = 0; c < n; c++) {
            final var c2 = columnCount - 1 - c;
            for (var r = 0; r < rowCount; r++) {
                if (getValue(r, c) != getValue(r, c2)) return false;
            }
        }
        return true;
    }
}