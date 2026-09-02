package ar.edu.unq.po2.tp3;

public class Point {
    //Atributos
    private int x;
    private int y;

    //Constructores
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Accessors
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Otros métodos

    public void movePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void sumPoints(Point point) {
        this.x += point.getX();
        this.y += point.getY();
    }
}
