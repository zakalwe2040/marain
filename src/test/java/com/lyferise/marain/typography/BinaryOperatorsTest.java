package com.lyferise.marain.typography;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class BinaryOperatorsTest {

    @Test
    public void shouldRenderBinaryOperators() {
        final var symbols = new Symbols();
        final var renderer = new TypographicRenderer(symbols);
        final var slate = renderer.render("+*-/%");
        slate.writeSvg(Paths.get("docs/binary-operators.svg"));
    }
}