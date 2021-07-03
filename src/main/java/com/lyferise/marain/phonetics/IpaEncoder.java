package com.lyferise.marain.phonetics;

import com.lyferise.marain.MarainCharacter;
import com.lyferise.marain.MarainText;

import static com.lyferise.marain.phonetics.Phoneme.*;
import static com.lyferise.marain.typography.Diacritic.*;

public class IpaEncoder {
    private final MarainText text;
    private final StringBuilder out = new StringBuilder();
    private final int length;
    private int position;

    public IpaEncoder(final MarainText text) {
        this.text = text;
        this.length = text.getCharacterCount();
    }

    public String encode() {
        while (canRead()) {
            encode(next());
        }
        return out.toString();
    }

    private void encode(final MarainCharacter character) {
        final var unicode = character.getGlyph().getCodePoint();
        final var diacritic = character.getDiacritic();
        switch (unicode) {
            case 'z' -> {
                append(Z);
                append(A);
            }
            case 'k' -> {
                append(K);
                append(A);
            }
            case 'l' -> {
                append(L);
                if (diacritic != STOP) append(A);
            }
            case 'w' -> {
                append(W);
                if (diacritic == UP && canRead() && peek().getGlyph().getCodePoint() == 'y') {
                    next();
                    append(LONG_A);
                } else {
                    append(A);
                }
            }
            case 'y' -> {
                append(Y);
                append(A);
            }
            case 'j' -> {
                append(J);
                append(A);
            }
            case 'A' -> append(LONG_VOWEL);
            case 'n' -> append(N);
            case 'h' -> {
                append(H);
                if (diacritic == OUT) append(U);
            }
            case 'b' -> {
                append(B);
                if (diacritic != STOP) append(A);
            }
            default -> throw new UnsupportedOperationException("Unsupported unicode '" + unicode + "'.");
        }
    }

    private void append(final Phoneme phoneme) {
        out.append(phoneme.getIpa());
    }

    private boolean canRead() {
        return position < length;
    }

    private MarainCharacter peek() {
        return text.getCharacter(position);
    }

    private MarainCharacter next() {
        return text.getCharacter(position++);
    }
}