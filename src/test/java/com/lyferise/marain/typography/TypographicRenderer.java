package com.lyferise.marain.typography;

import com.lyferise.marain.MarainText;
import com.lyferise.marain.geometry.Point;
import com.lyferise.marain.transliteration.Detransliterator;
import com.lyferise.marain.typography.lattice.AnnotatedSlateChannel;
import com.lyferise.marain.typography.lattice.LatticeVisualSettings;
import com.lyferise.marain.typography.visuals.LayoutContext;
import com.lyferise.marain.typography.visuals.Slate;
import com.lyferise.marain.typography.visuals.Styles;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class TypographicRenderer {
    private static final int SPACING_X = 100;
    private static final int SPACING_Y = 120;
    private final Symbols symbols;

    public TypographicRenderer(final Symbols symbols) {
        this.symbols = symbols;
    }

    public Slate render(final String... in) {
        final var detransliterator = new Detransliterator(symbols);
        final var text = stream(in).map(detransliterator::detransliterate).collect(toList());
        final var bounds = getBounds(text);
        final var width = 80 + SPACING_X * (bounds.getX() - 1);
        final var height = SPACING_Y * bounds.getY();
        final var slate = new Slate(width, height);
        final var settings = new LatticeVisualSettings();
        final var styles = slate.getStyles();
        final var layoutContext = slate.getLayoutContext();
        for (var i = 0; i < text.size(); i++) {
            layoutGlyphs(
                    width - 60,
                    10 + i * SPACING_Y,
                    slate,
                    settings,
                    styles,
                    layoutContext,
                    text.get(i));
        }
        return slate;
    }

    private void layoutGlyphs(final int x,
                              final int y,
                              final Slate slate,
                              final LatticeVisualSettings settings,
                              final Styles styles,
                              final LayoutContext layoutContext,
                              final MarainText text) {

        for (var i = 0; i < text.getCharacterCount(); i++) {
            slate.add(
                    new AnnotatedSlateChannel(
                            x - SPACING_X * i,
                            y,
                            settings,
                            styles,
                            layoutContext,
                            text.getCharacter(i).getGlyph()));
        }
    }

    private Point getBounds(final List<MarainText> text) {
        return text.size() == 0
                ? new Point(0, 0)
                : new Point(text.stream().map(MarainText::getCharacterCount).max(Integer::compare).get(), text.size());
    }
}