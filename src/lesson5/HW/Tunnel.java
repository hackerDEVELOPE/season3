package lesson5.HW;

public class Tunnel extends Stage{
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель "+ length+ " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName()+ " готовится к этапу: "+ description);

                c.getSemaphore().acquire();
                System.out.println(c.getName()+ " начал этап: "+ description);
                Thread.sleep(length/ c.getSpeed()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);

                c.getSemaphore().release();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
