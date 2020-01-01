package fde.processing.sketches;

import processing.core.PApplet;

public class FoolingAroundWithTheMouse extends PApplet {
    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        clear();
        // fullScreen(1);
        // fullScreen(2);
        // fullScreen(SPAN);

        background(5465);
    }

    private int i = 0;

    @Override
    public void draw() {
        ++i;

        stroke(255, 0, 0);
        fill(0, 255, 0);

        boolean b = ((i % 2) == 0);

        if (b) {
            circle(this.mouseX, this.mouseY, 20);
        } else {
            rect(this.mouseX, this.mouseY, 20, 20);
        }

        if (this.mousePressed) {
            setup();
        }


        print("abc");
        println("asdfasdf");

    }


    public static void main(String[] args) {
        PApplet.main(FoolingAroundWithTheMouse.class);
    }
}
