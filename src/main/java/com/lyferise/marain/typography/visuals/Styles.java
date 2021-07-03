package com.lyferise.marain.typography.visuals;

import lombok.Value;

import java.awt.*;

import static java.awt.Color.decode;
import static java.awt.Font.*;

@Value
public class Styles {
    Color red = decode("#DF5437");
    Color green = decode("#77F157");
    Color blue = decode("#3E79B3");
    Color yellow = decode("#FFFF00");
    Color background = decode("#202020");
    Color annotation = decode("#EEEEEE");
    Color annotationLight = decode("#FFDE34");;
    Font codePointFont = new Font("Arial", BOLD, 16);
    Font phonemeFont = new Font("Arial", ITALIC, 20);
}