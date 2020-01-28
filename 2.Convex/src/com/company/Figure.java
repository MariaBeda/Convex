package com.company;

import java.awt.*;

interface Figure {
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics g);
}
