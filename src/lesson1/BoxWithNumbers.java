package lesson1;

public class BoxWithNumbers<T extends Number> {
    private T[] arr;

    public BoxWithNumbers(T... arr) {
        this.arr = arr;
    }
    public double avg(){
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].doubleValue();

        }
        return sum / arr.length;
    }
    public boolean sameAvg(BoxWithNumbers<?> another){
        return Math.abs(this.avg() - another.avg()) < 0.00001;
    }
}
