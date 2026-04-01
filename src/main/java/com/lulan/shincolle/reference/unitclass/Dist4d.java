package com.lulan.shincolle.reference.unitclass;

public class Dist4d {
    public static final Dist4d ZERO = new Dist4d(0.0, 0.0, 0.0, 0.0);
    public static final Dist4d ONE = new Dist4d(1.0, 1.0, 1.0, 1.732051);
    public double x;
    public double y;
    public double z;
    public double d;

    public Dist4d(double x, double y, double z, double d) {
        if (x == -0.0) {
            x = 0.0;
        }
        if (y == -0.0) {
            y = 0.0;
        }
        if (z == -0.0) {
            z = 0.0;
        }
        if (d == -0.0) {
            d = 0.0;
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }

    public void scale(double s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
        this.d *= s;
    }
}
