package com.lyferise.marain.phonetics;

import com.lyferise.marain.transliteration.Detransliterator;
import com.lyferise.marain.typography.Symbols;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class IpaEncoderTest {

    @Test
    public void shouldEncodeMarainWithDiacritics() {
        final var map = Map.of(
                "zakalowayo", "zakalweɪ",
                "hubo", "hub",
                "jaAano", "ʤaːn");

        final var symbols = new Symbols();
        final var detransliterator = new Detransliterator(symbols);

        for (final var e : map.entrySet()) {
            final var text = detransliterator.detransliterate(e.getKey());
            final var ipaEncoder = new IpaEncoder(text);
            assertThat(ipaEncoder.encode(), is(equalTo(e.getValue())));
        }
    }
}