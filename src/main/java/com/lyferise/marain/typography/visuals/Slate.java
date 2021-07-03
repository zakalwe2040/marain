package com.lyferise.marain.typography.visuals;

import lombok.Getter;
import lombok.SneakyThrows;
import org.jfree.svg.SVGGraphics2D;

import java.awt.*;
import java.nio.file.Path;

import static java.nio.file.Files.writeString;

@Getter
public class Slate extends VisualElement {
    Styles styles = new Styles();
    LayoutContext layoutContext = new LayoutContext();

    public Slate(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.fill = styles.getBackground();
    }

    @Override
    public void render(final int ox, final int oy, final VisualContext context) {
        final var graphics = context.getGraphics();
        graphics.setPaint(fill);
        graphics.fillRect(ox, oy, width, height);
        graphics.setStroke(new BasicStroke(2));
        super.render(ox, oy, context);
    }

    @SneakyThrows
    public void writeSvg(final Path path) {

        // render
        final var graphics = new SVGGraphics2D(width, height);
        render(0, 0, new VisualContext(graphics));

        // write
        writeString(path, graphics.getSVGDocument());
    }
}