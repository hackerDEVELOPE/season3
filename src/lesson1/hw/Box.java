package lesson1.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> content;
    public Box(ArrayList<T> content) {
        this.content = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.content = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<T> getContent() {
        return content;
    }



    public void setContent(ArrayList<T> content) {
        this.content = content;
    }

    public float getWeight(){
        float sum = 0.0f;
        for (T t : getContent()) {
            sum += t.getWeight();
        }
        return sum;
    }
    public void addFruit(T fruit){
        getContent().add(fruit);
    }
    @SafeVarargs
    public final void addFruit(T... fruits){
        for (T fruit : fruits) {
            getContent().add(fruit);
        }
    }
    public boolean compare(Box<?> box){
        return Math.abs(getWeight() - box.getWeight()) < 0.000001f;
    }

    public void contentMove(Box<T> box){
        if (this == box){
            System.out.println("Dont move box to the same box!");
            throw new IllegalArgumentException();
        }
        box.getContent().addAll(this.getContent());
        getContent().clear();
    }
}
