package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.MarainCharacter;
import com.lyferise.marain.typography.glyphs.DiacriticChannel;
import com.lyferise.marain.typography.visuals.Styles;
import com.lyferise.marain.typography.visuals.VisualElement;

public class CharacterVisual extends VisualElement {

    public CharacterVisual(
            final int x,
            final int y,
            final LatticeVisualSettings settings,
            final Styles styles,
            final MarainCharacter character,
            final boolean tones) {

        this.x = x;
        this.y = y;
        final var spacingX = settings.getSpacingX();
        final var spacingY = settings.getSpacingY();
        add(new LatticeVisual(0, 0, settings, styles.getRed(), new DiacriticChannel(character.getDiacritic(), true)));
        add(new LatticeVisual(0, spacingY, settings, styles.getGreen(), character.getGlyph().getSlateChannel()));
        add(new LatticeVisual(0, 4 * spacingY, settings, styles.getBlue(), new DiacriticChannel(character.getDiacritic(), false)));
        if (tones) add(new TonalChannelVisual(3 * spacingX, 0, settings, styles.getYellow()));
    }
}