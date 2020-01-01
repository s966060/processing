package fde.processing.sketches;

import processing.core.PApplet;

public class CursorTail extends PApplet {

    @Override
    public void settings() {
        size(800, 800);
    }

    @Override
    public void setup() {
        clear();
        // fullScreen(1);
        // fullScreen(2);
        // fullScreen(SPAN);


        background(0, 0, 255);
    }

    private final int size = 150;
    private final float scale = 255.0f / size;

    private int i = 0;
    private int j = 0;

    private int[] x = new int[size];
    private int[] y = new int[size];

    private int skipped = 0;

    private void f(int x, int y, float r, float g, float b) {
        stroke(r, g, b);
        fill(r, g, b);

        // rect(x, y, 10, 10);
        circle(x, y, 20);
    }

    @Override
    public void draw() {
        if (this.mouseX != x[j] || this.mouseY != y[j]) {
            x[i] = this.mouseX;
            y[i] = this.mouseY;

            int k = ((i + 1) % size);
            f(x[k], y[k], 0, 0, 255);

            int m = size;

            for (int n = ((i + 2) % size); n != i; n = ((n + 1) % size)) {
                f(x[n], y[n], 255 - scale * m, 0, scale * m);
                --m;
            }

            f(x[i], y[i], 255, 0, 0);

            j = i;
            i = (i + 1) % size;
        } else {
            ++skipped;

            if ((skipped % 100) == 0) {
                println("skipped = " + skipped);
            }
        }
    }


    public static void main(String[] args) {
        PApplet.main(CursorTail.class);
    }
}
