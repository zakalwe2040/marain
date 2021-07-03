package com.lyferise.marain.typography.glyphs;

public class Bits {

    public static boolean getBit(final int value, final int position) {
        return ((value >> position) & 1) != 0;
    }
}