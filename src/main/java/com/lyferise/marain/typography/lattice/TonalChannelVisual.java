package com.lyferise.marain.typography.lattice;

import com.lyferise.marain.typography.visuals.VisualElement;

import java.awt.*;

public class TonalChannelVisual extends VisualElement {

    public TonalChannelVisual(final int x, final int y, final LatticeVisualSettings settings, final Color color) {
        this.x = x;
        this.y = y;
        final var spacingY = settings.getSpacingY();
        final var diameter = settings.getDiameter();
        for (var i = 0; i < 5; i++) {
            add(new LatticePointVisual(0, i * spacingY, diameter, color, false));
        }
    }
}