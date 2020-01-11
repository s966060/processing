package fde.processing.fractal_tree;

import fde.processing.common.ProcessingOutline;
import processing.core.PApplet;

import java.awt.*;

public class FractalTree2 extends ProcessingOutline {
    @Override
    public void settings() {
        setSize(900, 900);
    }

    @Override
    public void setup() {
        int level = 8;

        int x = 500;
        int y = 800;

        int length = 600;

        translate(x, y);
        rotate(radians(180));
        strokeWeight(1);

        f(level, length);
    }

    static class X {
        final float lengthRatio;
        final float angle;
        final Color color;

        public X(float lengthRatio, float angle, Color color) {
            this.lengthRatio = lengthRatio;
            this.angle = angle;
            this.color = color;
        }

        public float lengthRatio(float trunkRatio) {
            float branchRatio = this.lengthRatio * trunkRatio;
            return branchRatio;
        }

        public void color(PApplet applet) {
            // int colorValue = applet.color(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
            applet.stroke(this.color.getRGB());
        }
    }

    static class Config {
        final X left;
        final X mid;
        final X right;

        public Config(X left, X mid, X right) {
            this.left = left;
            this.mid = mid;
            this.right = right;
        }
    }

    final static Config CONFIG = new Config
            (
            new X(0.3f, -30f,   Color.RED),
            new X(0.0f, +0.0f,  Color.GREEN),
            new X(0.5f, +15f,   Color.BLUE)
            );

    void f(int level, float trunkLength) {
        if (level <= 0) {
            return;
        }

        CONFIG.mid.color(this);
        line(0, 0, 0, trunkLength);

        g(level, trunkLength, CONFIG.left);
        g(level, trunkLength, CONFIG.mid);
        g(level, trunkLength, CONFIG.right);
    }

    private void g(int level, float trunkLength, X x) {
        pushMatrix();
        float branchLength = x.lengthRatio(trunkLength);

        x.color(this);
        translate(0, branchLength);
        rotate(radians(x.angle));

        line(0, 0, 0, branchLength);
        f(level - 1, branchLength);
        popMatrix();
    }

    @Override
    public void draw() {
        super.draw();
    }

    public static void main(String[] args) {
        PApplet.main(FractalTree2.class);
    }
}
