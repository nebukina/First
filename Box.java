import java.util.ArrayList;

public class Box <F extends Fruit> {
    private ArrayList<F> Arr1 = new ArrayList<>();

    public Box(ArrayList<F> fruits){
        fruits.forEach(it-> add(it));
    }

    ArrayList<F> getFruits()  {
        return new ArrayList<>(Arr1);
    }

    F getObj() {
       return Arr1.get(0);
    }

    private float getWeight() {
        if (getObj() instanceof Apple) {
            return Arr1.size() * Apple.Weight;
        } else if (getObj() instanceof Orange) {
            return Arr1.size() * Orange.Weight;
        } else {
            throw new RuntimeException("incorrect type");
        }
    }

    private boolean compare(Box box) {
        if (getWeight() == box.getWeight()) {
            return true;
        } else {
            return false;
        }
    }

    void add(F fruit) {
        if (Arr1.size() == 0 || getObj().getClass() == fruit.getClass()) {
            Arr1.add(fruit);
        } else {
            throw new RuntimeException("!!!");
        }
    }

    void addBox(Box<F> fruits) {
        fruits.getFruits().forEach(it-> add(it));
    }
}
