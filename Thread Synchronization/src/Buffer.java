public class Buffer {
    protected int size;
    protected int q[];
    protected int inptr=0;
    protected int outptr=0;
    Semaphore empty;
    Semaphore full;
    Buffer(int size){
        this.size = size;
        q = new int[this.size];
        empty=new Semaphore(size);
        full =new Semaphore(0);

    }

    public void push(int n)  {
        empty.acquire();
        q[inptr]=n;
        inptr=(inptr+1)%size;

        full.release();
    }
    public int pop() {
        int value;
        full.acquire();
        value=q[outptr];
        outptr=(outptr+1)%size;
        empty.release();
        return value;

    }
}
