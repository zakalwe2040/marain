package com.lyferise.marain.typography;

import com.lyferise.marain.typography.glyphs.Glyph;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.fail;

public class SymbolsTest {

    @Test
    public void glyphValuesShouldBeUnique() {
        final var symbols = new Symbols();
        final var map = new HashMap<Integer, Glyph>();

        for (final var symbol : symbols) {
            if (symbol instanceof Glyph) {
                var glyph = (Glyph) symbol;
                final var value = glyph.getValue();
                final var match = map.get(value);
                if (match != null) {
                    fail("Glyph '" + glyph + "' has the same value as glyph '" + match + "'.");
                }
                map.put(value, glyph);
            }
        }
    }
}