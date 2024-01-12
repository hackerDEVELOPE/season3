package lesson4.p2_synch_counter;

public class Counter {
    private int c;

    public int value(){return c;}

    public Counter() {
        this.c = 0;
    }

    public void inc(){
        c++;
    }
    public void dec(){
        c--;
    }
}
