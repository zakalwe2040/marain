package com.lyferise.marain.transliteration;

import com.lyferise.marain.MarainTextBuilder;
import com.lyferise.marain.typography.Symbols;
import com.lyferise.marain.typography.glyphs.Glyph;
import org.junit.jupiter.api.Test;

import static com.lyferise.marain.typography.Diacritic.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TransliterationTest {

    @Test
    public void shouldTransliterateMarainWithoutDiacritics() {

        final var symbols = new Symbols();
        final var textBuilder = new MarainTextBuilder();
        textBuilder.append((Glyph) symbols.get('z'));
        textBuilder.append((Glyph) symbols.get('k'));
        textBuilder.append((Glyph) symbols.get('l'));
        textBuilder.append((Glyph) symbols.get('w'));
        textBuilder.append((Glyph) symbols.get('y'));

        final var text = textBuilder.toText();
        final var transliterator = new Transliterator();
        assertThat(transliterator.transliterate(text), is(equalTo("zklwy")));
    }

    @Test
    public void shouldTransliterateMarainWithDiacritics() {

        final var symbols = new Symbols();
        final var textBuilder = new MarainTextBuilder();
        textBuilder.append((Glyph) symbols.get('z'), UP);
        textBuilder.append((Glyph) symbols.get('k'), UP);
        textBuilder.append((Glyph) symbols.get('l'), STOP);
        textBuilder.append((Glyph) symbols.get('w'), UP);
        textBuilder.append((Glyph) symbols.get('y'), STOP);

        final var text = textBuilder.toText();
        final var transliterator = new Transliterator();
        assertThat(transliterator.transliterate(text), is(equalTo("zakalowayo")));
    }
}