package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    Square square;
    @BeforeEach
    public void setUp() {
        square = new Square(new Point(), 5);
    }

    @Test
    public void testArea() {
        assertEquals(25, square.area());
    }

    @Test
    public void testPerimeter() {
        assertEquals(20, square.perimeter());
    }

    @Test
    public void testIsVertical() {
        assertFalse(square.isVertical());
    }

    @Test
    public void testIsHorizontal() {
        assertTrue(square.isHorizontal());
    }

}
