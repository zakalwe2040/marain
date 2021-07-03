package com.lyferise.marain.typography;

public enum Diacritic implements Symbol {
    UP('a'),
    OUT('u'),
    DOWN('i'),
    STOP('o');

    private final char codePoint;

    Diacritic(final char codePoint) {
        this.codePoint = codePoint;
    }

    @Override
    public int getCodePoint() {
        return codePoint;
    }

    public static Diacritic of(final char codePoint) {
        return switch (codePoint) {
            case 'a' -> UP;
            case 'u' -> OUT;
            case 'i' -> DOWN;
            case 'o' -> STOP;
            default -> null;
        };
    }
}