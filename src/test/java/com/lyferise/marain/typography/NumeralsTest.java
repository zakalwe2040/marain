package com.lyferise.marain.typography;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class NumeralsTest {

    @Test
    public void shouldRenderNumerals() {
        final var symbols = new Symbols();
        final var renderer = new TypographicRenderer(symbols);
        final var slate = renderer.render("01234", "56789");
        slate.writeSvg(Paths.get("docs/numerals.svg"));
    }
}