package com.lyferise.marain.transliteration;

import com.lyferise.marain.typography.Symbols;
import org.junit.jupiter.api.Test;

import static com.lyferise.marain.typography.Diacritic.UP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetransliterationTest {

    @Test
    public void shouldTransliterateMarainWithoutDiacritics() {
        final var symbols = new Symbols();
        final var detransliterator = new Detransliterator(symbols);

        final var text = detransliterator.detransliterate("zklwy");
        assertThat(text.getCharacterCount(), is(equalTo(5)));
        assertThat(text.getCodePoint(0), is(equalTo((int) 'z')));
        assertThat(text.getCodePoint(1), is(equalTo((int) 'k')));
        assertThat(text.getCodePoint(2), is(equalTo((int) 'l')));
        assertThat(text.getCodePoint(3), is(equalTo((int) 'w')));
        assertThat(text.getCodePoint(4), is(equalTo((int) 'y')));
    }

    @Test
    public void shouldTransliterateMarainWithDiacritics() {
        final var symbols = new Symbols();
        final var detransliterator = new Detransliterator(symbols);

        final var text = detransliterator.detransliterate("zakalowayo");
        assertThat(text.getCharacterCount(), is(equalTo(5)));
        assertThat(text.getCodePoint(0), is(equalTo((int) 'z')));
        assertThat(text.getDiacritic(0), is(equalTo(UP)));
        assertThat(text.getCodePoint(1), is(equalTo((int) 'k')));
        assertThat(text.getCodePoint(2), is(equalTo((int) 'l')));
        assertThat(text.getCodePoint(3), is(equalTo((int) 'w')));
        assertThat(text.getCodePoint(4), is(equalTo((int) 'y')));
    }
}