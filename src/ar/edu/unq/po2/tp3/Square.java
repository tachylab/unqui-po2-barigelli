package ar.edu.unq.po2.tp3;

public class Square extends Rectangle {

    public Square(Point superiorLeftPoint, int side) {
        super(superiorLeftPoint, side, side);
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }
}
