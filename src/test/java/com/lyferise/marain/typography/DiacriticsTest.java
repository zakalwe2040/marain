package com.lyferise.marain.typography;

import com.lyferise.marain.transliteration.Detransliterator;
import com.lyferise.marain.typography.lattice.LatticeVisualSettings;
import com.lyferise.marain.typography.lattice.CharacterVisual;
import com.lyferise.marain.typography.visuals.Slate;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class DiacriticsTest {

    @Test
    public void shouldRenderDiacritics() {
        final var symbols = new Symbols();
        final var slate = new Slate(585, 105);
        final var settings = new LatticeVisualSettings();
        final var detransliterator = new Detransliterator(symbols);
        final var text = detransliterator.detransliterate("zakalowayo \uD83D\uDC9B jaAano");
        for (var i = 0; i < text.getCharacterCount(); i++) {
            final var character = text.getCharacter(i);
            if (character != null) {
                slate.add(
                        new CharacterVisual(
                                520 - 50 * i,
                                20,
                                settings,
                                slate.getStyles(),
                                character,
                                false));
            }
        }
        slate.writeSvg(Paths.get("docs/diacritics.svg"));
    }
}