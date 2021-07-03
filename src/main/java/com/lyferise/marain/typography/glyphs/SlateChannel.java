package com.lyferise.marain.typography.glyphs;

import com.lyferise.marain.geometry.AbstractLattice;
import lombok.EqualsAndHashCode;
import lombok.Value;

import static com.lyferise.marain.typography.glyphs.Bits.getBit;

@Value
@EqualsAndHashCode(callSuper = false)
public class SlateChannel extends AbstractLattice {
    int value;
    SlatePath path = new SlatePath();

    public SlateChannel(final int value) {
        this.value = value;
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean getValue(int rowIndex, int columnIndex) {
        return getBit(value, 8 - (rowIndex * 3 + columnIndex));
    }
}