package com.lyferise.marain.phonetics;

public enum Phoneme {
    K("k"),
    L("l"),
    W("w"),
    Z("z"),
    A("a"),
    U("u"),
    Y("y"),
    N("n"),
    H("h"),
    B("b"),
    LONG_A("eɪ"),
    J("ʤ"),
    LONG_VOWEL("ː"),
    LONG_I("aɪ");

    private final String ipa;

    Phoneme(final String ipa) {
        this.ipa = ipa;
    }

    public String getIpa() {
        return ipa;
    }
}