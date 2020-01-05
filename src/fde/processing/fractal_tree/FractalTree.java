package fde.processing.fractal_tree;

import fde.processing.common.ProcessingOutline;
import processing.core.PApplet;

public class FractalTree extends ProcessingOutline {
    @Override
    public void settings() {
        setSize(600, 600);
    }

    @Override
    public void setup() {
        int level = 8;

        int x = 300;
        int y = 550;

        int length = 200;

        translate(x, y);
        rotate(radians(180));

        blue();
        strokeWeight(1);

        f(level, length);
    }

    void f(int level, float trunkLength) {
        if (level <= 0) {
            return;
        }

        float branchLength = trunkLength / 1.5f;
        float branchAngle = 40;

        // green();
        // circle(0, 0, 10);
        line(0, 0, 0, trunkLength);

        translate(0, trunkLength);

        pushMatrix();
        rotate(radians(branchAngle));
        // red();
        line(0, 0, 0, branchLength);
        f(level - 1, branchLength);
        popMatrix();

        pushMatrix();
        rotate(radians(-branchAngle));
        // blue();
        line(0, 0, 0, branchLength);
        f(level - 1, branchLength);
        popMatrix();
    }

    @Override
    public void draw() {
        super.draw();
    }

    public static void main(String[] args) {
        PApplet.main(FractalTree.class);
    }
}
