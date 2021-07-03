package com.lyferise.marain.typography;

import com.lyferise.marain.typography.glyphs.Glyph;

import java.util.*;

import static com.lyferise.marain.typography.Diacritic.*;

public class Symbols implements Iterable<Symbol> {
    private final Map<Integer, Symbol> codePointMap = new HashMap<>();
    private final Map<Integer, Glyph> valueMap = new HashMap<>();
    private final List<Symbol> symbols = new ArrayList<>();

    public Symbols() {
        addDiacritics();
        addAbjad();
        addNumerals();
        addEmojis();
    }

    public void add(final Symbol symbol) {
        symbols.add(symbol);
        codePointMap.put(symbol.getCodePoint(), symbol);
        if (symbol instanceof Glyph) {
            final var glyph = (Glyph) symbol;
            valueMap.put(glyph.getValue(), glyph);
        }
    }

    public Symbol get(final int codePoint) {
        return codePointMap.get(codePoint);
    }

    public Glyph of(final int value) {
        return valueMap.get(value);
    }

    @Override
    public Iterator<Symbol> iterator() {
        return symbols.iterator();
    }

    private void addDiacritics() {
        add(UP);
        add(OUT);
        add(DOWN);
        add(STOP);
    }

    private void addAbjad() {
        add(new Glyph("001001111", "793", 'm', "ma"));
        add(new Glyph("111111111", "1793082", 'w', "wa"));
        add(new Glyph("111001001", "139", 'p', "pa"));
        add(new Glyph("111100100", "317", 'b', "ba"));
        add(new Glyph("101101010", "14863", 'f', "fa"));
        add(new Glyph("010101101", "74269", 'v', "va"));
        add(new Glyph("101000010", "183", 'T', "tha"));
        add(new Glyph("111111100", "713046", 'D', "dtha"));
        add(new Glyph("111111001", "93064031", 'x', "cha"));
        add(new Glyph("001010111", "3789", 'j', "dja"));
        add(new Glyph("011110100", "4237", 't', "ta"));
        add(new Glyph("101101111", "1793", 'n', "na"));
        add(new Glyph("111101101", "7139", 's', "sa"));
        add(new Glyph("111010001", "130259", 'd', "da"));
        add(new Glyph("100100111", "14789", 'l', "la"));
        add(new Glyph("101010111", "1973", 'z', "za"));
        add(new Glyph("101111010", "1463058", 'r', "ra"));
        add(new Glyph("111111101", "7139025", 'S', "sha"));
        add(new Glyph("100010111", "197", 'y', "ya"));
        add(new Glyph("110110111", "147890852", 'g', "ga"));
        add(new Glyph("100110111", "14789085", 'k', "ka"));
        add(new Glyph("101111111", "1793085", 'N', "nga"));
        add(new Glyph("010000101", "7297", 'A', "aa"));
        add(new Glyph("111100111", "3179", 'h', "ha"));
        // add(new Glyph("111101111", "123698741", 'h', "ha"));
    }

    private void addNumerals() {
        add(new Glyph("101010101", "19037", '0', "líng"));
        add(new Glyph("111010111", "13079028", '1', "yī"));
        add(new Glyph("010010111", "28097", '2', "èr"));
        add(new Glyph("001111001", "39064", '3', "sān"));
        add(new Glyph("011110011", "3289054", '4', "sì"));
        add(new Glyph("111011001", "1391", '5', "wǔ"));
        add(new Glyph("101110101", "9173", '6', "liù"));
        add(new Glyph("101111001", "146039", '7', "qī"));
        add(new Glyph("101111100", "170364", '8', "bā"));
        add(new Glyph("101111101", "7193", '9', "jiǔ"));
    }

    private void addEmojis() {
        add(new Glyph("101110010", "51054058053", 0x1F596, "shacha"));
        add(new Glyph("010001100", "726", 0x1F928, "samara"));
        add(new Glyph("111101010", "136841", 0x1F49B, "hub"));
        add(new Glyph("101110110", "17045", 0x2728, "zing"));
        add(new Glyph("010010101", "25057059", 0x1F64F, "yam"));
        add(new Glyph("100011011", "56985", 0x1F495, "wun"));
        add(new Glyph("101010001", "91", 0x1F923, "shaa"));
        add(new Glyph("101010100", "37", 0x1F602, "mar"));
        add(new Glyph("101110100", "5475", 0x1F60A, "hoo"));
        add(new Glyph("101110111", "1971", 0x1F970, "lang"));
        add(new Glyph("101010000", null, 0x1F618, "gang"));
        add(new Glyph("101101101", "17", 0x1F609, "shii"));
        add(new Glyph("101010110", "587", 0x1F44D, "shai"));
        add(new Glyph("101011011", "56985", 0x1F632, "zang"));
        add(new Glyph("101111011", "4684", 0x1F60D, "shuu"));
        add(new Glyph("101010010", "58", 0x1F97A, "ging"));
        add(new Glyph("101001000", null, 0x1F622, "bay"));
        add(new Glyph("101101000", null, 0x1F62D, "buz"));
        add(new Glyph("101000101", null, 0x1F922, "yan"));
        add(new Glyph("101011010", "658", 0x1F621, "fin"));
        add(new Glyph("101111000", "46", 0x1F971, "pil"));
        add(new Glyph("101000000", null, 0x1F628, "paa"));
    }
}