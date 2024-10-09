package org.example.HW1.Point;

public class Point implements Movable {
    private float coordinateX;
    private float coordinateY;

    public void setCoordinateX(float coordinateX) {
        this.coordinateX = coordinateX;
    }

    public float getCoordinateX() {
        return this.coordinateX;
    }

    public void setCoordinateY(float coordinateY) {
        this.coordinateY = coordinateY;
    }

    public float getCoordinateY() {
        return this.coordinateY;
    }

    @Override
    public void moveUp() {
        coordinateY++;
    }

    @Override
    public void moveDown() {
        coordinateY--;
    }

    @Override
    public void moveLeft() {
        coordinateX++;
    }

    @Override
    public void moveRight() {
        coordinateX--;
    }
}