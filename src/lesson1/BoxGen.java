package lesson1;

public class BoxGen<T> {
    // T type
    // E element
    // K key
    // V value
    // N number
    private T obj;

    public BoxGen(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
