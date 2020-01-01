package fde.processing.sketches;

import processing.core.PApplet;

public class MyFirst extends PApplet {
    public void settings() {
        size(600, 600);
    }

    public void setup() {
        background(0x58540F);
    }

    private int i = 0;

    public void draw() {
        ++i;

        int a = 100 + ((i + 1) % 50);
        int b = 250 + ((i + 1) % 100);
        int c = 400 + ((i + 1) % 150);

        stroke(255, 0, 0);
        fill(0, 255, 0);
        rect(a, a, 150, 100);

        stroke(0);
        fill(255);
        circle(b, b, 222);


        stroke(80);
        fill(120);
        ellipse(c, c, 222, 111);

        stroke(0x58540F);
        line(0, 0, 100, 100);
    }

    public static void main(String[] args) {
        PApplet.main(MyFirst.class);
    }
}