package com.lyferise.marain.geometry;

import com.lyferise.marain.typography.glyphs.SlatePath;

public interface Lattice {

    int getRowCount();

    int getColumnCount();

    boolean getValue(int rowIndex, int columnIndex);

    SlatePath getPath();

    boolean hasHorizontalSymmetry();

    boolean hasVerticalSymmetry();
}