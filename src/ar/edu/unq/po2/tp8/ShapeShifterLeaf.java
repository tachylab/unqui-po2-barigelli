package ar.edu.unq.po2.tp8;

import java.util.List;

public class ShapeShifterLeaf implements IShapeShifter{

    private int value;

    public ShapeShifterLeaf(int value) {
        this.value = value;
    }

    public IShapeShifter compose(IShapeShifter shapeShifter) {
        ShapeShifterComposite nuevoCompuesto = new ShapeShifterComposite();
        nuevoCompuesto.agregar(this);
        nuevoCompuesto.agregar(shapeShifter);
        return nuevoCompuesto;
    }

    public int deepest() {
        return 0;
    }

    public IShapeShifter flat() {
        return this;
    }

    public List<Integer> values() {
        return List.of(value);
    }
}
