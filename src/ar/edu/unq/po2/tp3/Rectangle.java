package ar.edu.unq.po2.tp3;

public class Rectangle {
    //Atributos
    protected Point superiorLeftPoint;
    protected int height;
    protected int width;

    //Constructores
    public Rectangle(Point superiorLeftPoint, int height, int width) {
        this.superiorLeftPoint = superiorLeftPoint;
        this.height = height;
        this.width = width;
    }

    //Accessors
    public Point getSuperiorLeftPoint() {
        return superiorLeftPoint;
    }

    public void setSuperiorLeftPoint(Point superiorLeftPoint) {
        this.superiorLeftPoint = superiorLeftPoint;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    //Otros métodos
    public int area() {
        return height * width;
    }

    public int perimeter() {
        return 2 * (width + height);
    }

    public boolean isVertical() {
        return height > width;
    }

    public boolean isHorizontal() {
        return !isVertical();
    }
}
