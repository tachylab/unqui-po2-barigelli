package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    Rectangle rectangle;
    @BeforeEach
    public void setUp() {
        rectangle = new  Rectangle(new Point(), 5, 3);
    }

    @Test
    public void testArea() {
        assertEquals(15, rectangle.area());
    }

    @Test
    public void testPerimeter() {
        assertEquals(16, rectangle.perimeter());
    }

    @Test
    public void testIsVertical() {
        assertTrue(rectangle.isVertical());
    }

    @Test
    public void testIsHorizontal() {
        assertFalse(rectangle.isHorizontal());
    }

}
