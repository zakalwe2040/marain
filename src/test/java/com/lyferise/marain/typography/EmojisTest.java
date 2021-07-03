package com.lyferise.marain.typography;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class EmojisTest {

    @Test
    public void shouldRenderEmojis() {
        final var symbols = new Symbols();
        final var renderer = new TypographicRenderer(symbols);
        final var slate = renderer.render(
                "\uD83D\uDD96\uD83E\uDD28",
                "\uD83D\uDC9B\u2728\uD83D\uDE4F\uD83D\uDC95\uD83E\uDD23\uD83D\uDE02\uD83D\uDE0A\uD83E\uDD70\uD83D\uDE18\uD83D\uDE09\uD83D\uDC4D\uD83D\uDE32\uD83D\uDE0D",
                "\uD83E\uDD7A\uD83D\uDE22",
                "\uD83D\uDE2D\uD83E\uDD22\uD83D\uDE21\uD83E\uDD71\uD83D\uDE28");
        slate.writeSvg(Paths.get("docs/emojis.svg"));
    }
}