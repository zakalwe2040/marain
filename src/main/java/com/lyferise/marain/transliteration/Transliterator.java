package com.lyferise.marain.transliteration;

import com.lyferise.marain.MarainCharacter;
import com.lyferise.marain.MarainText;

public class Transliterator {

    public String transliterate(final MarainText text) {
        final var out = new StringBuilder();
        for (final MarainCharacter character : text) {
            out.append((char) character.getGlyph().getCodePoint());
            final var diacritic = character.getDiacritic();
            if (diacritic != null) out.append((char) diacritic.getCodePoint());
        }
        return out.toString();
    }
}