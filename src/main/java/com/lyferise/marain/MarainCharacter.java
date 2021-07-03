package com.lyferise.marain;

import com.lyferise.marain.typography.Diacritic;
import com.lyferise.marain.typography.glyphs.Glyph;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class MarainCharacter {
    Glyph glyph;
    Diacritic diacritic;

    @Override
    public String toString() {
        final var text = new StringBuilder();
        text.append(glyph);
        if (diacritic != null) {
            text.append('+');
            text.append((char) diacritic.getCodePoint());
        }
        return text.toString();
    }
}