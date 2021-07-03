package com.lyferise.marain.typography;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class AbjadTest {

    @Test
    public void shouldRenderAbjad() {
        final var symbols = new Symbols();
        final var renderer = new TypographicRenderer(symbols);
        final var slate = renderer.render("mwpb", "fv", "TDxj", "tnsdlz", "rS", "y", "gkN", "Ah");
        slate.writeSvg(Paths.get("docs/abjad.svg"));
    }
}