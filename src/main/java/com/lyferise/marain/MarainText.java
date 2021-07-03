package com.lyferise.marain;

import com.lyferise.marain.typography.Diacritic;

import java.util.Iterator;

import static java.util.Arrays.stream;

public class MarainText implements Iterable<MarainCharacter> {
    private final MarainCharacter[] characters;

    public MarainText(final MarainCharacter[] characters) {
        this.characters = characters;
    }

    @Override
    public Iterator<MarainCharacter> iterator() {
        return stream(characters).iterator();
    }

    public int getCharacterCount() {
        return characters.length;
    }

    public MarainCharacter getCharacter(final int index) {
        return characters[index];
    }

    public int getCodePoint(final int index) {
        return characters[index].getGlyph().getCodePoint();
    }

    public Diacritic getDiacritic(final int index) {
        return characters[index].getDiacritic();
    }

    @Override
    public String toString() {
        final var text = new StringBuilder();
        for (final var character : characters) {
            if (text.length() > 0) text.append(' ');
            text.append(character);
        }
        return text.toString();
    }
}