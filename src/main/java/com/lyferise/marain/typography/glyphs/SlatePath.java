package com.lyferise.marain.typography.glyphs;

import com.lyferise.marain.geometry.Point;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class SlatePath {
    List<Point> points = new ArrayList<>();

    public void add(final String value) {
        for (var i = 0; i < value.length(); i++) {
            points.add(lineTo(value.charAt(i) - '0'));
        }
    }

    private Point lineTo(final int point) {
        if (point == 0) return null;
        final var i = point - 1;
        return new Point(i % 3, i / 3);
    }
}