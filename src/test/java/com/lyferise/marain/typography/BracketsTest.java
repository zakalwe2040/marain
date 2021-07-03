package com.lyferise.marain.typography;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class BracketsTest {

    @Test
    public void shouldRenderBrackets() {
        final var symbols = new Symbols();
        final var renderer = new TypographicRenderer(symbols);
        final var slate = renderer.render("><", "][", ")(", "}{");
        slate.writeSvg(Paths.get("docs/brackets.svg"));
    }
}