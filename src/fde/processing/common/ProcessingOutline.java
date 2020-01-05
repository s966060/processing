package fde.processing.common;

import processing.core.PApplet;

public class ProcessingOutline extends PApplet {
    @Override
    public void settings() {
        super.settings();
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void red() {
        stroke(color(255, 0, 0));
    }

    public void green() {
        stroke(color(0, 255, 0));
    }

    public void blue() {
        stroke(color(0, 0, 255));
    }

    public static void main(String[] args) {
        PApplet.main(ProcessingOutline.class);
    }
}
