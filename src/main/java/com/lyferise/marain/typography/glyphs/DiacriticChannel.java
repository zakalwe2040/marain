package com.lyferise.marain.typography.glyphs;

import com.lyferise.marain.geometry.AbstractLattice;
import com.lyferise.marain.typography.Diacritic;

public class DiacriticChannel extends AbstractLattice {
    private final Diacritic diacritic;
    private final boolean upperChannel;
    private final SlatePath path = new SlatePath();

    public DiacriticChannel(final Diacritic diacritic, final boolean upperChannel) {
        this.diacritic = diacritic;
        this.upperChannel = upperChannel;

        if (diacritic != null) {
            switch (diacritic) {
                case UP -> {
                    if (upperChannel) path.add("13");
                }
                case DOWN -> {
                    if (!upperChannel) path.add("13");
                }
            }
        }
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean getValue(int rowIndex, int columnIndex) {
        if (diacritic == null) return false;
        return switch (diacritic) {
            case UP -> upperChannel;
            case OUT -> upperChannel && columnIndex == 0;
            case DOWN -> !upperChannel;
            case STOP -> upperChannel && columnIndex == 2;
        };
    }

    @Override
    public SlatePath getPath() {
        return path;
    }
}