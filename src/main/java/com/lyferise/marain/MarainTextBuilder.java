package com.lyferise.marain;

import com.lyferise.marain.typography.Diacritic;
import com.lyferise.marain.typography.glyphs.Glyph;

import java.util.ArrayList;
import java.util.List;

public class MarainTextBuilder {
    private final List<MarainCharacter> characters = new ArrayList<>();

    public MarainTextBuilder space() {
        characters.add(null);
        return this;
    }

    public MarainTextBuilder append(final Glyph glyph) {
        append(glyph, null);
        return this;
    }

    public MarainTextBuilder append(final Glyph glyph, final Diacritic diacritic) {
        characters.add(new MarainCharacter(glyph, diacritic));
        return this;
    }

    public MarainText toText() {
        final var characters = new MarainCharacter[this.characters.size()];
        this.characters.toArray(characters);
        return new MarainText(characters);
    }
}