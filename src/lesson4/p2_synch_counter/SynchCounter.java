package lesson4.p2_synch_counter;
// 1 монитор на методы, которые связаны друг с другом
public class SynchCounter {
    private int c;
    private final Object mon = new Object();

    public int value() {return c;}
    public SynchCounter(){c=0;}
    public synchronized void inc (){
        c++;
    }
    public synchronized void dec (){
        c--;
    }

    public void inc1(){
        synchronized (mon){
            c++;
        }
    }
    public void dec1(){
        synchronized (mon){
            c--;
        }
    }
}
