package fde.processing.fractal_tree;

import fde.processing.common.ProcessingOutline;
import processing.core.PApplet;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FractalTree2 extends ProcessingOutline {
    @Override
    public void settings() {
        setSize(900, 900);
    }

    @Override
    public void setup() {
        int level = 6;

        int x = 500;
        int y = 800;

        int length = 400;

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

        public float branchLength(float trunkLength) {
            float branchLength = this.lengthRatio * trunkLength;
            return branchLength;
        }

        public void color(PApplet applet) {
            applet.stroke(this.color.getRGB());
        }
    }

    static class XList implements Iterable<X> {
        private final List<X> list;

        public XList(X... x) {
            this.list = new ArrayList<>();
            this.list.addAll(Arrays.asList(x));
        }

        public float trunkLength(float trunkLength) {
            float maxLengthRatio = 0.0f;

            for (X x : this) {
                maxLengthRatio = Math.max(maxLengthRatio, x.lengthRatio);
            }

            return trunkLength * maxLengthRatio;
        }

        @Override
        public Iterator<FractalTree2.X> iterator() {
            return this.list.iterator();
        }
    }

    final static XList X_LIST = new XList(
            new X(0.3f, -60.0f, Color.RED),
            new X(0.7f, -15.0f, Color.GREEN),
            new X(0.7f, +15.0f, Color.PINK),
            new X(0.5f, +45.0f, Color.BLUE)
    );

    void f(int level, float trunkLength) {
        if (level <= 0) {
            return;
        }

        stroke(Color.BLACK.getRGB());
        line(0, 0, 0, X_LIST.trunkLength(trunkLength));

        for (X x : X_LIST) {
            g(level, trunkLength, x);
        }
    }

    private void g(int level, float trunkLength, X x) {
        pushMatrix();
        float branchLength = x.branchLength(trunkLength);
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
