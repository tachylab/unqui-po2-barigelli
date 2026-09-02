package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    Point punto;
    @BeforeEach
    public void setUp() {
        punto = new Point(5,5);
    }

    @Test
    public void constructorsPointTest() {
        //Verificar que se guardan bien los datos
        assertEquals(5, punto.getX());
        assertEquals(5, punto.getY());

        //Verificar si el constructor nulo da un punto (0,0)
        Point puntoNulo = new Point();
        assertEquals(0, puntoNulo.getX());
        assertEquals(0, puntoNulo.getY());
    }

    @Test
    public void movePointTest() {
        //Testear que funcione bien
        punto.movePoint(10, 3);
        assertEquals(10, punto.getX());
        assertEquals(3, punto.getY());
    }

    @Test
    public void sumPointsTest() {
        //Testear que la suma del punto original con otro punto de las sumas de sus coordenadas
        Point punto2 = new Point(8,16);
        punto.sumPoints(punto2);
        assertEquals(13, punto.getX());
        assertEquals(21, punto.getY());
    }
}
