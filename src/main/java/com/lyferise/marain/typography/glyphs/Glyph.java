package com.lyferise.marain.typography.glyphs;

import com.lyferise.marain.typography.Symbol;
import lombok.Value;

import static java.lang.Integer.parseInt;

@Value
public class Glyph implements Symbol {
    SlateChannel slateChannel;
    int codePoint;
    String phonemeText;

    public Glyph(
            final String latticeValue,
            final String pathValue,
            final int codePoint,
            final String phonemeText) {

        this(parseInt(latticeValue, 2), pathValue, codePoint, phonemeText);
    }

    public Glyph(
            final int latticeValue,
            final String pathValue,
            final int codePoint,
            final String phonemeText) {

        this.slateChannel = new SlateChannel(latticeValue);
        if (pathValue != null) this.slateChannel.getPath().add(pathValue);
        this.codePoint = codePoint;
        this.phonemeText = phonemeText;
    }

    public int getValue() {
        return slateChannel.getValue();
    }

    @Override
    public String toString() {
        return Character.toString(codePoint);
    }
}