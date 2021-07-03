package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.typography.glyphs.Glyph;
import com.lyferise.marain.typography.visuals.LayoutContext;
import com.lyferise.marain.typography.visuals.Styles;
import com.lyferise.marain.typography.visuals.TextElement;
import com.lyferise.marain.typography.visuals.VisualElement;

import static java.lang.Math.round;

public class AnnotatedSlateChannel extends VisualElement {

    public AnnotatedSlateChannel(
            final int x,
            final int y,
            final LatticeVisualSettings settings,
            final Styles styles,
            final LayoutContext layoutContext,
            final Glyph glyph) {

        this.x = x;
        this.y = y;

        final var unicodeText = new TextElement(
                Character.toString(glyph.getCodePoint()),
                styles.getAnnotationLight(),
                styles.getCodePointFont(),
                layoutContext);
        centerX(settings, unicodeText);
        add(unicodeText);

        add(new LatticeVisual(0, 28, settings, styles.getGreen(), glyph.getSlateChannel()));

        final var phonemeText = new TextElement(
                glyph.getPhonemeText(),
                styles.getAnnotation(),
                styles.getPhonemeFont(),
                layoutContext);

        centerX(settings, phonemeText);
        phonemeText.setY(settings.getSpacingY() * 5);
        add(phonemeText);
    }

    private void centerX(final LatticeVisualSettings settings, final VisualElement element) {
        final var spacingX = settings.getSpacingX();
        final var diameter = settings.getDiameter();
        element.setX((int) round((spacingX * 2 + diameter - 1.75 * element.getWidth()) / 2));
    }
}