package ar.edu.unq.po2.tp8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeShifterComposite implements IShapeShifter {
    private List<IShapeShifter> hijos = new ArrayList<>();

    @Override
    public IShapeShifter compose(IShapeShifter shapeShifter) {
        ShapeShifterComposite nuevoCompuesto = new ShapeShifterComposite();
        nuevoCompuesto.agregar(this);
        nuevoCompuesto.agregar(shapeShifter);
        return nuevoCompuesto;
    }

    @Override
    public int deepest() {
        return 1 + hijos.stream().mapToInt(IShapeShifter::deepest).max().orElse(0);
    }

    @Override
    public IShapeShifter flat() {
        ShapeShifterComposite plano = new ShapeShifterComposite();

        for (Integer val : this.values()) {
            plano.agregar(new ShapeShifterLeaf(val));
        }

        return plano;
    }

    @Override
    public List<Integer> values() {
        List<Integer> acumulado = new ArrayList<>();
        for (IShapeShifter hijo : hijos) {
            acumulado.addAll(hijo.values());
        }
        return acumulado;
    }

    public void agregar(IShapeShifter shapeShifter) {
        this.hijos.add(shapeShifter);
    }

}
