package com.lyferise.marain.transliteration;

import com.lyferise.marain.MarainText;
import com.lyferise.marain.MarainTextBuilder;
import com.lyferise.marain.typography.Diacritic;
import com.lyferise.marain.typography.Symbols;
import com.lyferise.marain.typography.glyphs.Glyph;

public class Detransliterator {
    private final Symbols symbols;

    public Detransliterator(final Symbols symbols) {
        this.symbols = symbols;
    }

    public MarainText detransliterate(final String text) {
        final var out = new MarainTextBuilder();
        for (var i = 0; i < text.length(); i++) {

            // code point
            final var codePoint = text.codePointAt(i);
            final var characterCount = Character.charCount(codePoint);;
            i += characterCount - 1;

            // symbol
            final var symbol = symbols.get(codePoint);
            if (symbol == null) {
                out.space();
                continue;
            }

            // glyph
            if (!(symbol instanceof Glyph)) {
                throw new UnsupportedOperationException("Expected a glyph at index " + i + " not " + symbol);
            }
            final var glyph = (Glyph) symbol;

            // diacritic?
            final var diacritic = i < text.length() - 1 ? Diacritic.of(text.charAt(i + 1)) : null;
            out.append(glyph, diacritic);
            if (diacritic != null) i++;
        }
        return out.toText();
    }
}