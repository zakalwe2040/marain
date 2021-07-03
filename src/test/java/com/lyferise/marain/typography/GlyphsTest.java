package com.lyferise.marain.typography;

import com.lyferise.marain.typography.glyphs.Glyph;
import com.lyferise.marain.typography.lattice.AnnotatedSlateChannel;
import com.lyferise.marain.typography.lattice.LatticeVisualSettings;
import com.lyferise.marain.typography.visuals.Slate;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static java.lang.String.valueOf;

public class GlyphsTest {

    @Test
    public void shouldRenderGlyphs() {
        final var symbols = new Symbols();
        final var slate = new Slate(1220, 3855);
        final var settings = new LatticeVisualSettings();
        final var styles = slate.getStyles();
        final var layoutContext = slate.getLayoutContext();
        var value = 0;
        for (var rowIndex = 0; rowIndex < 32; rowIndex++) {
            for (var columnIndex = 0; columnIndex < 16; columnIndex++) {
                var glyph = symbols.of(value);
                if (glyph == null) {
                    glyph = new Glyph(value, "", ' ', valueOf(value + 1));
                }
                if (glyph.getSlateChannel().hasVerticalSymmetry() && glyph.getCodePoint() == 32) {
                    slate.add(
                            new AnnotatedSlateChannel(
                                    1150 - 75 * columnIndex,
                                    20 + 120 * rowIndex,
                                    settings,
                                    styles,
                                    layoutContext,
                                    glyph));
                }
                value++;
            }
        }
        slate.writeSvg(Paths.get("docs/glyphs.svg"));
    }
}