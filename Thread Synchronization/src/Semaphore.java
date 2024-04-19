public class Semaphore {
    protected int value ;

    public Semaphore(int v) {
        this.value=v;
    }

    public synchronized void acquire()  {
        value--;
        if (value < 0) {
            notifyAll();
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public synchronized void release() {
        value++;
        notify();
    }

}





