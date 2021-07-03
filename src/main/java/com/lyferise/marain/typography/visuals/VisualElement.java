package com.lyferise.marain.typography.visuals;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VisualElement {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color stroke;
    protected Color fill;
    protected List<VisualElement> elements = new ArrayList<>();

    public void add(final VisualElement element) {
        elements.add(element);
    }

    public void render(final int ox, final int oy, final VisualContext context) {
        for (final VisualElement child : elements) {
            child.render(ox + x, oy + y, context);
        }
    }
}